package com.sls.test.nio;

import static org.junit.Assert.*;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

import org.junit.Test;

import com.google.common.base.Preconditions;

public class TestChannel {

	@Test
	public void test() throws IOException {
		RandomAccessFile file = new RandomAccessFile("E:/Test/xxx.txt", "rw");
		FileChannel channel = file.getChannel();
		ByteBuffer buf = ByteBuffer.allocate(48);
		int bytesRead = channel.read(buf);
		while (bytesRead != -1) {
			System.out.println("Read:" + bytesRead);
			buf.flip();
			while (buf.hasRemaining()) {
				System.out.println(buf.getChar());
			}
			buf.clear();
			bytesRead = channel.read(buf);
		}
		file.close();
	}

}
