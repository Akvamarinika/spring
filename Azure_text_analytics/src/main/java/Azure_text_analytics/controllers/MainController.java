package Azure_text_analytics.controllers;
import Azure_text_analytics.objects.AzureAPI;
import Azure_text_analytics.objects.DocumentsWrapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;
import java.net.URISyntaxException;

@Controller
public class MainController {

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("title", "Azure Text Analytics");
        return "index";
    }

    @PostMapping("/")
    public String getPost(@RequestParam String user_text, Model model){
        try {
            AzureAPI.setTextUser(user_text);
            System.out.println(user_text);
            AzureAPI.APIRequest();
            String json = AzureAPI.getResponse();
            System.out.println(json);
            DocumentsWrapper documentsWrapper = AzureAPI.parseJSON(json);
            AzureAPI.setTextWithTag(documentsWrapper);
            model.addAttribute("text_with_tag", AzureAPI.getTextWithTag());
            AzureAPI.sortSentences(documentsWrapper);
            model.addAttribute("docs_sort", documentsWrapper.getDocuments());
            AzureAPI.printInfo(documentsWrapper);
        } catch (IOException | URISyntaxException e) {
            e.printStackTrace();
        }
        return "result";
    }

}
