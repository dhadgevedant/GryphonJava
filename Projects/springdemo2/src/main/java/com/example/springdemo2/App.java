package com.example.springdemo2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.stream.Collectors;

@SpringBootApplication
@RestController
public class App {

	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}

	@GetMapping("/")
	public String hello() {
		return "Hello, World!";
	}

	@GetMapping("/run")
	public String runCommand(@RequestParam(value = "cmd", defaultValue = "whoami") String cmd) {
		try {
			ProcessBuilder processBuilder = new ProcessBuilder();
			processBuilder.command("/bin/zsh", "-c", cmd);
			Process process = processBuilder.start();
			
			String output;
			try (BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()))) {
				output = reader.lines().collect(Collectors.joining("\n"));
			}
			
			String error;
			try (BufferedReader errorReader = new BufferedReader(new InputStreamReader(process.getErrorStream()))) {
				error = errorReader.lines().collect(Collectors.joining("\n"));
			}
			
			int exitCode = process.waitFor();
			
			StringBuilder response = new StringBuilder();
			if (!output.isEmpty()) {
				response.append("Output:\n").append(output).append("\n");
			}
			if (!error.isEmpty()) {
				response.append("Error:\n").append(error).append("\n");
			}
			if (output.isEmpty() && error.isEmpty()) {
				response.append("(No output received)\n");
			}
			response.append("Exit Code: ").append(exitCode);
			
			return response.toString();
		} catch (Exception e) {
			return "Execution failed: " + e.getMessage();
		}
	}
}
