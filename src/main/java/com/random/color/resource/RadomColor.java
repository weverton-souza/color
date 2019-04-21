package com.random.color.resource;

import com.random.color.domain.Color;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@CrossOrigin
@RestController
@RequestMapping("/color")
public class RadomColor {
    private Random rand;
    RadomColor() {
        this.rand = new Random();
    }

    @RequestMapping(method = RequestMethod.GET)
    public Color getRandomColor() {
        return new Color()
                    .setHexColor(this.generateColor(this.rand));
    }

    private String generateColor(Random rand) {
        final char [] hex = {
                '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'
        };
        char [] s = new char[7];
        int n = rand.nextInt(0x1000000);

        s[0] = '#';
        for(short i = 1; i < 7; i++) {
            s[i] = hex[n & 0xf]; n >>= 4;
        }
        return new String(s);
    }
}
