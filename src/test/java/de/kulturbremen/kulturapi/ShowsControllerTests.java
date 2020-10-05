package de.kulturbremen.kulturapi;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import java.time.Instant;
import java.time.temporal.ChronoUnit;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class ShowsControllerTests {

    @Autowired
    private MockMvc mockMvc;
    private final String startDate = Instant.now().toString();
    private final String stopDate = Instant.now().plus(7, ChronoUnit.DAYS).toString();

    @Test
    public void noParamShowsShouldReturnShows() throws Exception {

        this.mockMvc.perform(get("/shows"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.showList").isNotEmpty());
    }

    @Test
    public void paramShowsShouldReturnShows() throws Exception {
        this.mockMvc.perform(get("/shows")
                .param("startdate", startDate).param("stopdate", stopDate))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.showList").isNotEmpty());
    }

    @Test
    public void paramShowsShouldReturnRightDates() throws Exception {
        this.mockMvc.perform(get("/shows")
                .param("startdate", startDate).param("stopdate", stopDate))
                .andExpect(jsonPath("$.startDate").value(startDate))
                .andExpect(jsonPath("$.stopDate").value(stopDate));
    }


}
