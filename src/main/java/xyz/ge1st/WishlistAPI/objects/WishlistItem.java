package xyz.ge1st.WishlistAPI.objects;

import java.util.Objects;

public class WishlistItem {

    private String imgUrl;
    private String title;
    private String comment;
    private String price;
    private String amount;
    private String received;

    public WishlistItem(String imgUrl, String title, String comment, String price, String amount, String received) {
        this.imgUrl = imgUrl;
        this.title = title;
        this.comment = comment;
        this.price = price;
        this.amount = amount;
        this.received = received;
    }

    public WishlistItem() {
        // Empty constructor stub
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof WishlistItem)) {
            return false;
        }
        WishlistItem wli = (WishlistItem) o;

        return Objects.equals(this.imgUrl, wli.imgUrl)
                && Objects.equals(this.title, wli.title) && Objects.equals(this.comment, wli.comment)
                && Objects.equals(this.price, wli.price) && Objects.equals(this.amount, wli.amount)
                && Objects.equals(this.received, wli.received);

    }

    @Override
    public int hashCode() {
        return Objects.hash(this.imgUrl, this.title, this.comment, this.price, this.amount, this.received);
    }

    @Override
    public String toString() {
        return "WishlistItem{" + "imgUrl='" + this.imgUrl + '\'' + this.title + '\'' +
                ", comment='" + this.comment + '\'' + ", price='" + this.price + '\'' + ", amount='" + this.amount +
                '\'' + ", received='" + this.received + '\'' + '}';
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getReceived() {
        return received;
    }

    public void setReceived(String received) {
        this.received = received;
    }
}
