package com.innefu.controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.StreamingResponseBody;

import java.io.IOException;
import java.io.OutputStream;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("/api")
public class StreamingController {

    @GetMapping("/stream")
    public StreamingResponseBody streamData() {
        return new StreamingResponseBody() {
            @Override
            public void writeTo(OutputStream outputStream) throws IOException {
                ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
                
                // Simulate streaming data line by line
                executor.scheduleAtFixedRate(() -> {
                    try {
                        // Generate a new line of data
                        String line = "Line of data at fdghj dfhjghk rtyui dfghl dfgh dfgh rdytugi rytui vvstrdfyg dfg fdfg dfhj fcghv xghj ghjk ghj  "+ "\n"
                        		+ "fghjkfgvhbj,nfsdgh dgfchvj sg fgdhj fxghvj fsdghjg fsdhgj fgdhj sgdhfj gsdhfj srtdyfg srydfv vrdytgu ydfhgj ydfg rdytf ";
                        
                        // Write the line to the output stream
                        outputStream.write(line.getBytes());
                        outputStream.flush(); // Ensure data is sent to client
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }, 0, 1, TimeUnit.SECONDS); // Write a new line every second
                
                // To stop the executor after some time, or implement your own stopping logic
                executor.schedule(() -> {
                    executor.shutdown(); // Stop the executor after 30 seconds
                }, 30, TimeUnit.SECONDS);
            }
        };
    }
}
