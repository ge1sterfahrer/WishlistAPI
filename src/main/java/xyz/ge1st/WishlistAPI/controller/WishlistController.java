package xyz.ge1st.WishlistAPI.controller;

import com.google.gson.Gson;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import xyz.ge1st.WishlistAPI.objects.Wishlist;
import xyz.ge1st.WishlistAPI.objects.WishlistItem;
import xyz.ge1st.WishlistAPI.web.WishlistReader;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
public class WishlistController {

        public static Logger logger = LoggerFactory.getLogger(WishlistController.class);

        @RequestMapping("/wishlist_api")
        public String index(@RequestParam Map<String, String> params) {

            // API parameters
            String tld = params.get("tld");
            String id = params.get("id");

            // Wishlist URL
            String url = "https://www.amazon." + tld + "/hz/wishlist/printview/" + id + "/";

            // Returncode
            String rc = "";

            List<WishlistItem> wishlistContent = new ArrayList<WishlistItem>();

            try {
                // Constructing WishlistReader object implicitly reads wishlist HTML from constructed URL
                WishlistReader wishlistReader = new WishlistReader(url);

                rc = wishlistReader.getHtmlContent();

                Document htmlDocument = Jsoup.parse(wishlistReader.getHtmlContent());

                Element wishlistName = htmlDocument.body().getElementById("printViewListTitle_" + id);
                Element wishListDesc = htmlDocument.body().getElementById("wlDesc");

                Wishlist wishlist = new Wishlist(wishlistName.children().get(0).text(), wishListDesc.text());

                Elements wishlistItems = htmlDocument.body().getElementsByClass("g-print-items");

                Element wishListItem = wishlistItems.get(0).child(0);

                int i = 0;
                for (Element e : wishListItem.children()) {

                    if (i > 0) {

                        String imgUrl = e.children().get(0).child(0).attr("src");
                        String title = e.children().get(1).text();
                        String comment = e.children().get(2).text();
                        String price = e.children().get(3).text();
                        String amount = e.children().get(4).text();
                        String received = e.children().get(5).text();

                        wishlistContent.add(new WishlistItem(imgUrl, title, comment, price, amount, received));
                    }
                    i++;
                }

                Gson gson = new Gson();
                String json = gson.toJson(wishlistContent);

                rc = json;

            } catch (IOException | InterruptedException e) {
                rc = e.getMessage();
                e.printStackTrace();
            }

            return rc;
        }
}


