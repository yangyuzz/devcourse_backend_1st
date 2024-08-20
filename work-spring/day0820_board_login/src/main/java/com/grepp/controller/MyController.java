package com.grepp.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public interface MyController {
    Object handleRequest(HttpServletRequest req, HttpServletResponse resp);
}
