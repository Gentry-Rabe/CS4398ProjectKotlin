package com.example.fixcsproject;

import com.example.fixcsproject.laundryapp.model.Employee;
import com.example.fixcsproject.laundryapp.model.Job;
import com.example.fixcsproject.laundryapp.model.JobStatus;

import org.junit.Test;
import static org.junit.Assert.*;

public class JobTest {

    @Test
    public void testJobStatusUpdatesCorrectly() {
        Job job = new Job(1, "Wash clothes", "Austin", 25.0);

        job.updateStatus(JobStatus.ACCEPTED);

        assertEquals(JobStatus.ACCEPTED, job.getStatus());
    }

    @Test
    public void testAssignEmployee() {
        Job job = new Job(1, "Wash clothes", "Austin", 25.0);
        Employee emp = new Employee(10, "Jane", "e@a.com", "pass");

        job.assignEmployee(emp);

        assertEquals(emp, job.getEmployee());
    }
}
