package sanqian.controllerunittest;

import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author yzhuang
 */
@Controller
public class ImAController {

    @GetMapping("/hello")
    public ResponseEntity hello(@NonNull @RequestParam(value = "n") String name) {
        System.out.println(name);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/gift")
    public ResponseEntity receiveGift(@NonNull @RequestParam(value = "g") String gift,
                                      @NonNull @RequestParam(value = "v") Integer value) {
        System.out.println(gift);
        System.out.println(value);
        return ResponseEntity.ok().build();
    }

}
