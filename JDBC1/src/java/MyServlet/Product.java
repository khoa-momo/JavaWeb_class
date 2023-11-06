/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MyServlet;

import java.io.Serializable;

/**
 *
 * @author DELL
 */
public class Product implements Serializable{
    private int ProductID;
    private String ProductName;
    private String SupplierID;
    private String CategoryID;
    private String QuantityPerUnit;
    private String UnitPrice;
    private String UnitsInStock;
    private String UnitsOnOrder;
    private String ReorderLevel;
    private String Discontinued; 

    public Product() {
    }

    public Product(int ProductID, String ProductName, String SupplierID, String CategoryID, String QuantityPerUnit, String UnitPrice, String UnitsInStock, String UnitsOnOrder, String ReorderLevel, String Discontinued) {
        this.ProductID = ProductID;
        this.ProductName = ProductName;
        this.SupplierID = SupplierID;
        this.CategoryID = CategoryID;
        this.QuantityPerUnit = QuantityPerUnit;
        this.UnitPrice = UnitPrice;
        this.UnitsInStock = UnitsInStock;
        this.UnitsOnOrder = UnitsOnOrder;
        this.ReorderLevel = ReorderLevel;
        this.Discontinued = Discontinued;
    }

    public int getProductID() {
        return ProductID;
    }

    public void setProductID(int ProductID) {
        this.ProductID = ProductID;
    }

    public String getProductName() {
        return ProductName;
    }

    public void setProductName(String ProductName) {
        this.ProductName = ProductName;
    }

    public String getSupplierID() {
        return SupplierID;
    }

    public void setSupplierID(String SupplierID) {
        this.SupplierID = SupplierID;
    }

    public String getCategoryID() {
        return CategoryID;
    }

    public void setCategoryID(String CategoryID) {
        this.CategoryID = CategoryID;
    }

    public String getQuantityPerUnit() {
        return QuantityPerUnit;
    }

    public void setQuantityPerUnit(String QuantityPerUnit) {
        this.QuantityPerUnit = QuantityPerUnit;
    }

    public String getUnitPrice() {
        return UnitPrice;
    }

    public void setUnitPrice(String UnitPrice) {
        this.UnitPrice = UnitPrice;
    }

    public String getUnitsInStock() {
        return UnitsInStock;
    }

    public void setUnitsInStock(String UnitsInStock) {
        this.UnitsInStock = UnitsInStock;
    }

    public String getUnitsOnOrder() {
        return UnitsOnOrder;
    }

    public void setUnitsOnOrder(String UnitsOnOrder) {
        this.UnitsOnOrder = UnitsOnOrder;
    }

    public String getReorderLevel() {
        return ReorderLevel;
    }

    public void setReorderLevel(String ReorderLevel) {
        this.ReorderLevel = ReorderLevel;
    }

    public String getDiscontinued() {
        return Discontinued;
    }

    public void setDiscontinued(String Discontinued) {
        this.Discontinued = Discontinued;
    }
    
    
}
