/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dymsha.spip.lab1;

import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author eugene
 */
public class RequestParser {

    private double x;
    private double y;
    private double r;

    public RequestParser(HttpServletRequest aRequest) {
        this.x = getDoubleFromString(aRequest.getParameter("x"));
        this.y = getDoubleFromString(aRequest.getParameter("y"));
        this.r = getDoubleFromString(aRequest.getParameter("r"));

    }

    public double getX() {
        return this.x;

    }

    public double getY() {
        return this.y;

    }

    public double getR() {
        return this.r;

    }

    private double getDoubleFromString(String source) {
        return Double.parseDouble(source.replaceFirst(",", "."));

    }
}
