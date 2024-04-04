package algonquin.cst2335.finalproject.Models;

import java.util.ArrayList;

/**
 * Represents the pairing of wines with a recipe and provides product matches for wine-related products.
 * This class contains information about paired wines, pairing text, and product matches.
 *
 * Author: [Your Name]
 * Lab Session: [Lab Session Number]
 * Date: [Date]
 */
public class WinePairing {
    /** The list of wines that pair well with the recipe. */
    public ArrayList<String> pairedWines;

    /** Text describing the pairing of wines with the recipe. */
    public String pairingText;

    /** The list of product matches for wine-related products. */
    public ArrayList<ProductMatch> productMatches;

    // Constructors, getters, and setters can be added here for better encapsulation and flexibility.

    /**
     * Default constructor for creating a WinePairing instance without initializing fields.
     */
    public WinePairing() {
    }

    /**
     * Constructs a WinePairing instance with specified paired wines, pairing text, and product matches.
     *
     * @param pairedWines The list of wines that pair well with the recipe.
     * @param pairingText Text describing the pairing of wines with the recipe.
     * @param productMatches The list of product matches for wine-related products.
     */
    public WinePairing(ArrayList<String> pairedWines, String pairingText, ArrayList<ProductMatch> productMatches) {
        this.pairedWines = pairedWines;
        this.pairingText = pairingText;
        this.productMatches = productMatches;
    }

    // Example getters and setters

    /**
     * Gets the list of wines that pair well with the recipe.
     *
     * @return The list of paired wines.
     */
    public ArrayList<String> getPairedWines() {
        return pairedWines;
    }

    /**
     * Sets the list of wines that pair well with the recipe.
     *
     * @param pairedWines The list of paired wines to set.
     */
    public void setPairedWines(ArrayList<String> pairedWines) {
        this.pairedWines = pairedWines;
    }

    /**
     * Gets the pairing text describing the pairing of wines with the recipe.
     *
     * @return The pairing text.
     */
    public String getPairingText() {
        return pairingText;
    }

    /**
     * Sets the pairing text describing the pairing of wines with the recipe.
     *
     * @param pairingText The pairing text to set.
     */
    public void setPairingText(String pairingText) {
        this.pairingText = pairingText;
    }

    /**
     * Gets the list of product matches for wine-related products.
     *
     * @return The list of product matches.
     */
    public ArrayList<ProductMatch> getProductMatches() {
        return productMatches;
    }

    /**
     * Sets the list of product matches for wine-related products.
     *
     * @param productMatches The list of product matches to set.
     */
    public void setProductMatches(ArrayList<ProductMatch> productMatches) {
        this.productMatches = productMatches;
    }
}
