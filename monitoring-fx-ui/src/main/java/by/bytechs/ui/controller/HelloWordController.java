package by.bytechs.ui.controller;

import by.bytechs.service.HelloWordService;
import de.felixroske.jfxsupport.FXMLController;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author Romanovich Andrei
 */
@FXMLController
public class HelloWordController {
    @FXML
    TextField helloWordTextField;
    @Autowired
    private HelloWordService helloWordService;

    @FXML
    public void initialize() {
        helloWordTextField.setText(helloWordService.getHelloWord());
    }
}