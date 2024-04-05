package algonquin.cst2335.finalproject.Models;

/**
 * Represents a product matched to a recipe, potentially as a recommendation for pairing or use.
 * This could include items like wines, cooking utensils, or ingredients. The class includes
 * details about the product such as its name, description, price, image URL, ratings, and a link
 * to where it can be purchased or learned more about.
 *
 * Author: Meet Maheta
 * Lab Session: 012
 * Date: 3 April 2024
 */
public class ProductMatch {
    /** The unique identifier for the product. */
    public int id;

    /** The title or name of the product. */
    public String title;

    /** A brief description of the product. */
    public String description;

    /** The price of the product, formatted as a string to include currency symbols or text. */
    public String price;

    /** The URL pointing to an image of the product. */
    public String imageUrl;

    /** The average rating of the product based on user reviews. */
    public double averageRating;

    /** The count of ratings or reviews the product has received. */
    public double ratingCount;

    /** A score calculated for the product, which could be based on various factors like popularity or matching algorithm's output. */
    public double score;

    /** A link to a web page for the product, where users can find more information or make a purchase. */
    public String link;

    // Constructors, getters, and setters can be added here for better encapsulation and data management.
}
