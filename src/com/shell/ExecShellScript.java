package com.shell;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class ExecShellScript {
	

	public static void main(String[] args) {
		
	}

	public static void checkOutSrc(String repoURL) {
		try {
			
			String path = "/home/srikanth/.jenkins/workspace/TFramework1/";
			Process proc = Runtime.getRuntime().exec(path + "script.sh " + repoURL);
			BufferedReader read = new BufferedReader(new InputStreamReader(proc.getInputStream()));
			try {
				proc.waitFor();
			} catch (InterruptedException e) {
				System.out.println(e.getMessage());
			}
			while (read.ready()) {
				System.out.println(read.readLine());
			}
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public static void copyFile(String fileName) {
		try {
			String execFilePath = "/home/srikanth/.jenkins/workspace/TFramework1/";
			String srcPath = "/home/srikanth/.jenkins/workspace/TFramework1/testsrc/"+fileName;
			String targetPath = "/home/srikanth/.jenkins/workspace/TFramework1/src/com/test";
			Process proc = Runtime.getRuntime().exec(execFilePath + "copyFilesScript.sh " + fileName+" "+targetPath);
			BufferedReader read = new BufferedReader(new InputStreamReader(proc.getInputStream()));
			try {
				proc.waitFor();
			} catch (InterruptedException e) {
				System.out.println(e.getMessage());
			}
			while (read.ready()) {
				System.out.println(read.readLine());
			}
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

	public static void compile(String fileName) {
		try {
			String execFilePath = "/home/srikanth/.jenkins/workspace/TFramework1/";
			String path = "/home/srikanth/.jenkins/workspace/TFramework1";
			String srcPath = "/home/srikanth/.jenkins/workspace/TFramework1/src/com/test/";
			//String targetPath = "/home/infra3/eclipse_workspace/selenium/s1/Selenium_Test/build/classes";
			String targetPath = "/home/srikanth/.jenkins/workspace/TFramework1/bin";
			fileName = srcPath+fileName;
			Process proc = Runtime.getRuntime().exec(execFilePath + "compile.sh " + targetPath +" "+fileName);
			BufferedReader read = new BufferedReader(new InputStreamReader(proc.getInputStream()));
			try {
				proc.waitFor();
			} catch (InterruptedException e) {
				System.out.println(e.getMessage());
			}
			while (read.ready()) {
				System.out.println(read.readLine());
			}
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public static void run(String fileName) {
		try {
			String execFilePath = "/home/srikanth/.jenkins/workspace/TFramework1/";
			String path = "/home/srikanth/.jenkins/workspace/TFramework1";
			fileName = "com.test."+fileName;
			Process proc = Runtime.getRuntime().exec(execFilePath + "run.sh " + fileName);
			BufferedReader read = new BufferedReader(new InputStreamReader(proc.getInputStream()));
			try {
				proc.waitFor();
			} catch (InterruptedException e) {
				System.out.println(e.getMessage());
			}
			while (read.ready()) {
				System.out.println(read.readLine());
			}
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
}
