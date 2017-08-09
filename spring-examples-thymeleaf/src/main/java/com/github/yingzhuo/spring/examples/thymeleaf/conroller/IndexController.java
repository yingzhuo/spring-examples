/*                  _                                                  _
 **  ___ _ __  _ __(_)_ __   __ _        _____  ____ _ _ __ ___  _ __ | | ___  ___
 ** / __| '_ \| '__| | '_ \ / _` |_____ / _ \ \/ / _` | '_ ` _ \| '_ \| |/ _ \/ __|
 ** \__ \ |_) | |  | | | | | (_| |_____|  __/>  < (_| | | | | | | |_) | |  __/\__ \
 ** |___/ .__/|_|  |_|_| |_|\__, |      \___/_/\_\__,_|_| |_| |_| .__/|_|\___||___/
 **    |_|                 |___/                               |_|
 **
 **        https://github.com/yingzhuo/spring-examples
 */
package com.github.yingzhuo.spring.examples.thymeleaf.conroller;

import com.github.yingzhuo.spring.examples.thymeleaf.model.Product;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;

@Controller
public class IndexController {

    private static final Product[] PRODUCTS = new Product[] {
            new Product("1", "Rogue", 3900D, true),
            new Product("2", "AV", 2900.0D, false)
    };

    @RequestMapping("/index")
    public String index(ModelMap modelMap) {
        modelMap.put("prod", new Product("1", "Rogue Vape Mod", 3900D, true));
        modelMap.put("now", new Date());
        modelMap.put("authorName", "应卓");
        return "index";
    }

}
