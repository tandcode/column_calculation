package ua.com.dbncalc.steel.config;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.web.bind.annotation.RequestMapping;

public class CalcErrorController implements ErrorController {
    @RequestMapping("/error")
    public String error(){
        return "error";
    }

    @Override
    public String getErrorPath() {
        return null;
    }
}
