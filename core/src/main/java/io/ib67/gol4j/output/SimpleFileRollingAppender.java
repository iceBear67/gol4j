package io.ib67.gol4j.output;

import io.ib67.gol4j.LoggerOutput;
import lombok.SneakyThrows;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class SimpleFileRollingAppender implements LoggerOutput {
    private final String pathPattern;
    private final long sizeInBytes;
    private final Lock lock = new ReentrantLock(true); // to keep order.
    private volatile Writer writer;
    private int fileNum = 0;
    private AtomicLong sizeWritten = new AtomicLong();

    public SimpleFileRollingAppender(String pathPattern, int sizeInMb) {
        this.pathPattern = pathPattern;
        this.sizeInBytes = (long) sizeInMb * 1024 * 1024;
        try {
            Files.createDirectories(Path.of(pathPattern).getParent());
            refreshWriter();
        } catch (IOException e) {
            throw new RuntimeException("Cannot initialize appender", e);
        }
    }

    private void refreshWriter() throws IOException {
        lock.lock();
        try {
            Path path;
            do {
                fileNum++;
                path = Path.of(String.format(pathPattern, fileNum)); //todo enhanced format support
                if (Files.notExists(path)) {
                    Files.createFile(path);
                }
                if (!path.toFile().isFile()) throw new IOException(path + " is not a file");
                sizeWritten.set(Files.size(path));
            } while (sizeWritten.get() >= sizeInBytes);

            writer = new FileWriter(path.toFile(),true);
            sizeWritten.set(0);
        } finally {
            lock.unlock();
        }
    }

    @SneakyThrows
    @Override
    public LoggerOutput flush(Object message) {
        var msg = (String) message;
        if (sizeWritten.addAndGet(msg.length()) > sizeInBytes) {
            refreshWriter();
        }
        writer.append(msg);
        writer.flush();
        return this;
    }
}
