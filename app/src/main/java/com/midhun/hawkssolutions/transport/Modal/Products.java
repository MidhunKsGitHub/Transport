package com.midhun.hawkssolutions.transport.Modal;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Index;
import androidx.room.PrimaryKey;

@Entity(tableName = "products", indices = @Index(value = {"id"},unique = true))

public class Products {
    public Products(String id, String name, String image, String thumb, String description, String metatitle, String metadescription, String metakeywords, String tags, String model, String upc, String isbn, String price, String mrp, String tax_id, String makingcharge, String stone_amount, String design, String quantity, String minimum_order_quantity, String subtract_stock, String out_of_stock_status, String shipping_charge, String date_available, String length, String width, String height, String length_class, String weight, String netWeight, String weight_class, String sort_order, String manufacturer, String categories, String category, String subcategories, String occassion, String purity, String gold_color, String material, String shop_for, String filters, String downloads, String related, String status, String deleteStatus, String updated, String priceAttribute, String discount_type, String discount, String offerStart, String offerEnds) {
        this.id = id;
        this.name = name;
        this.image = image;
        this.thumb = thumb;
        this.description = description;
        this.metatitle = metatitle;
        this.metadescription = metadescription;
        this.metakeywords = metakeywords;
        this.tags = tags;
        this.model = model;
        this.upc = upc;
        this.isbn = isbn;
        this.price = price;
        this.mrp = mrp;
        this.tax_id = tax_id;
        this.makingcharge = makingcharge;
        this.stone_amount = stone_amount;
        this.design = design;
        this.quantity = quantity;
        this.minimum_order_quantity = minimum_order_quantity;
        this.subtract_stock = subtract_stock;
        this.out_of_stock_status = out_of_stock_status;
        this.shipping_charge = shipping_charge;
        this.date_available = date_available;
        this.length = length;
        this.width = width;
        this.height = height;
        this.length_class = length_class;
        this.weight = weight;
        this.netWeight = netWeight;
        this.weight_class = weight_class;
        this.sort_order = sort_order;
        this.manufacturer = manufacturer;
        this.categories = categories;
        this.category = category;
        this.subcategories = subcategories;
        this.occassion = occassion;
        this.purity = purity;
        this.gold_color = gold_color;
        this.material = material;
        this.shop_for = shop_for;
        this.filters = filters;
        this.downloads = downloads;
        this.related = related;
        this.status = status;
        this.deleteStatus = deleteStatus;
        this.updated = updated;
        this.priceAttribute = priceAttribute;
        this.discount_type = discount_type;
        this.discount = discount;
        this.offerStart = offerStart;
        this.offerEnds = offerEnds;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getThumb() {
        return thumb;
    }

    public void setThumb(String thumb) {
        this.thumb = thumb;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getMetatitle() {
        return metatitle;
    }

    public void setMetatitle(String metatitle) {
        this.metatitle = metatitle;
    }

    public String getMetadescription() {
        return metadescription;
    }

    public void setMetadescription(String metadescription) {
        this.metadescription = metadescription;
    }

    public String getMetakeywords() {
        return metakeywords;
    }

    public void setMetakeywords(String metakeywords) {
        this.metakeywords = metakeywords;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getUpc() {
        return upc;
    }

    public void setUpc(String upc) {
        this.upc = upc;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getMrp() {
        return mrp;
    }

    public void setMrp(String mrp) {
        this.mrp = mrp;
    }

    public String getTax_id() {
        return tax_id;
    }

    public void setTax_id(String tax_id) {
        this.tax_id = tax_id;
    }

    public String getMakingcharge() {
        return makingcharge;
    }

    public void setMakingcharge(String makingcharge) {
        this.makingcharge = makingcharge;
    }

    public String getStone_amount() {
        return stone_amount;
    }

    public void setStone_amount(String stone_amount) {
        this.stone_amount = stone_amount;
    }

    public String getDesign() {
        return design;
    }

    public void setDesign(String design) {
        this.design = design;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getMinimum_order_quantity() {
        return minimum_order_quantity;
    }

    public void setMinimum_order_quantity(String minimum_order_quantity) {
        this.minimum_order_quantity = minimum_order_quantity;
    }

    public String getSubtract_stock() {
        return subtract_stock;
    }

    public void setSubtract_stock(String subtract_stock) {
        this.subtract_stock = subtract_stock;
    }

    public String getOut_of_stock_status() {
        return out_of_stock_status;
    }

    public void setOut_of_stock_status(String out_of_stock_status) {
        this.out_of_stock_status = out_of_stock_status;
    }

    public String getShipping_charge() {
        return shipping_charge;
    }

    public void setShipping_charge(String shipping_charge) {
        this.shipping_charge = shipping_charge;
    }

    public String getDate_available() {
        return date_available;
    }

    public void setDate_available(String date_available) {
        this.date_available = date_available;
    }

    public String getLength() {
        return length;
    }

    public void setLength(String length) {
        this.length = length;
    }

    public String getWidth() {
        return width;
    }

    public void setWidth(String width) {
        this.width = width;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getLength_class() {
        return length_class;
    }

    public void setLength_class(String length_class) {
        this.length_class = length_class;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getNetWeight() {
        return netWeight;
    }

    public void setNetWeight(String netWeight) {
        this.netWeight = netWeight;
    }

    public String getWeight_class() {
        return weight_class;
    }

    public void setWeight_class(String weight_class) {
        this.weight_class = weight_class;
    }

    public String getSort_order() {
        return sort_order;
    }

    public void setSort_order(String sort_order) {
        this.sort_order = sort_order;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getCategories() {
        return categories;
    }

    public void setCategories(String categories) {
        this.categories = categories;
    }

    public String getSubcategories() {
        return subcategories;
    }

    public void setSubcategories(String subcategories) {
        this.subcategories = subcategories;
    }

    public String getOccassion() {
        return occassion;
    }

    public void setOccassion(String occassion) {
        this.occassion = occassion;
    }

    public String getPurity() {
        return purity;
    }

    public void setPurity(String purity) {
        this.purity = purity;
    }

    public String getGold_color() {
        return gold_color;
    }

    public void setGold_color(String gold_color) {
        this.gold_color = gold_color;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public String getShop_for() {
        return shop_for;
    }

    public void setShop_for(String shop_for) {
        this.shop_for = shop_for;
    }

    public String getFilters() {
        return filters;
    }

    public void setFilters(String filters) {
        this.filters = filters;
    }

    public String getDownloads() {
        return downloads;
    }

    public void setDownloads(String downloads) {
        this.downloads = downloads;
    }

    public String getRelated() {
        return related;
    }

    public void setRelated(String related) {
        this.related = related;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDeleteStatus() {
        return deleteStatus;
    }

    public void setDeleteStatus(String deleteStatus) {
        this.deleteStatus = deleteStatus;
    }

    public String getUpdated() {
        return updated;
    }

    public void setUpdated(String updated) {
        this.updated = updated;
    }

    public String getPriceAttribute() {
        return priceAttribute;
    }

    public void setPriceAttribute(String priceAttribute) {
        this.priceAttribute = priceAttribute;
    }

    public String getDiscount_type() {
        return discount_type;
    }

    public void setDiscount_type(String discount_type) {
        this.discount_type = discount_type;
    }

    public String getDiscount() {
        return discount;
    }

    public void setDiscount(String discount) {
        this.discount = discount;
    }

    public String getOfferStart() {
        return offerStart;
    }

    public void setOfferStart(String offerStart) {
        this.offerStart = offerStart;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getOfferEnds() {
        return offerEnds;
    }

    public void setOfferEnds(String offerEnds) {
        this.offerEnds = offerEnds;
    }


    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    @PrimaryKey(autoGenerate = true)
    private int uid;
    private String id;

    @ColumnInfo(name = "name")
    private  String name;

    @ColumnInfo(name = "image")

    private  String image;

    @ColumnInfo(name = "description")
    private  String description;

    private String thumb,metatitle,metadescription,metakeywords,tags,model,upc,isbn,price,mrp,tax_id,makingcharge,stone_amount,design,quantity,minimum_order_quantity,subtract_stock,out_of_stock_status,shipping_charge,date_available,length,width,height,length_class,weight,netWeight,weight_class,sort_order,manufacturer,categories,category,subcategories,occassion,purity,gold_color,material,shop_for,filters,downloads,related,status,deleteStatus,updated,priceAttribute,discount_type,discount,offerStart,offerEnds;
}
