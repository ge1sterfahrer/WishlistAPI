package xyz.ge1st.WishlistAPI.objects;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Wishlist {

    private String title;
    private String description;
    private List<WishlistItem> wishlistItems;

    public Wishlist(String title, String description) {
        this.title = title;
        this.description = description;
        this.wishlistItems = new ArrayList<WishlistItem>();
    }

    public Wishlist() {
        this.wishlistItems = new ArrayList<WishlistItem>();
        // Empty constructor stub
    }

    public List<WishlistItem> getWishlistItems() {
        return wishlistItems;
    }

    public void setWishlistItems(List<WishlistItem> wishlistItems) {
        this.wishlistItems = wishlistItems;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Wishlist)) {
            return false;
        }
        Wishlist wl = (Wishlist) o;

        return Objects.equals(this.title, wl.title)
                && Objects.equals(this.description, wl.description);

    }

    @Override
    public int hashCode() {
        return Objects.hash(this.title, this.description);
    }

    @Override
    public String toString() {
        return "Wishlist{" + "title='" + this.title + '\'' +
                ", description='" + this.description + "\'}";
    }

}
