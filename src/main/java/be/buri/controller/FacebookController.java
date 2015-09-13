package be.buri.controller;

import lombok.extern.apachecommons.CommonsLog;
import org.springframework.social.facebook.api.Facebook;
import org.springframework.social.facebook.api.FacebookProfile;
import org.springframework.social.facebook.api.PagedList;
import org.springframework.social.facebook.api.Post;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;

/**
 * Created by buri on 2015. 9. 13..
 */
@Controller
@RequestMapping("/login/facebook")
@CommonsLog
public class FacebookController {
  private Facebook facebook;

  @Inject
  public FacebookController(Facebook facebook) {
    this.facebook = facebook;
  }

  @RequestMapping
  public String helloFacebook(Model model) {
    if (!facebook.isAuthorized()) {
      return "redirect:/connect/facebook";
    }
    model.addAttribute(facebook.userOperations().getUserProfile());
    PagedList<Post> homeFeed = facebook.feedOperations().getHomeFeed();
    model.addAttribute("feed", homeFeed);

    return "hello";
  }
}
