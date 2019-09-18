package me.ashaneediri.fbretrieve.controller;

import me.ashaneediri.fbretrieve.dto.page.PageDataDTO;
import me.ashaneediri.fbretrieve.service.FbDataRetrieveService;
import me.ashaneediri.fbretrieve.dto.post.PostListDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.io.UnsupportedEncodingException;

/**
 * Controller class to retrieve user facebook posts and pages.
 *
 */
@RestController
@RequestMapping("/api/facebook/")
public class FbDataRetrieveController {

    @Autowired
    private FbDataRetrieveService fbDataRetrieveService;

    @GetMapping("/posts")
    public ResponseEntity<PostListDTO> getFacebookPosts() {
        return ResponseEntity.ok().body(fbDataRetrieveService.getPosts());
    }

    @GetMapping("/pages")
    public ResponseEntity<PageDataDTO> getLikedFacebookPages() throws UnsupportedEncodingException {
        return ResponseEntity.ok().body(fbDataRetrieveService.getPages());
    }
}
