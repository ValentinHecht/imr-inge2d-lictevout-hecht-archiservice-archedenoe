package pierre.valentin.imt.ne.archedenoe.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import pierre.valentin.imt.ne.archedenoe.entity.Arche;

@RestController
public class ArcheController {

    @GetMapping("/api/arches")
    public void arche () {
        System.out.println("test");
    }
}
