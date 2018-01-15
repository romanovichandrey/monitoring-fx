package by.bytechs.service.impl;

import by.bytechs.service.HelloWordService;
import org.springframework.stereotype.Service;

/**
 * @author Romanovich Andrei
 */
@Service
public class HelloWordServiceImpl implements HelloWordService {

    @Override
    public String getHelloWord() {
        return "Hello Word";
    }
}