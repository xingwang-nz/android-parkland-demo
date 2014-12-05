package nz.co.guru.services.parkland;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import nz.co.guru.services.parkland.model.CatalogGroup;
import nz.co.guru.services.parkland.model.ProductItem;
import nz.co.guru.services.parkland.search.ProductFieldFilter;

/**
 * Temporary class to store the hard-code catalogs.
 */
public class ProductOrderManager {

    public static final String SELECTED_PRODUCT_ITEM = "SELECTED_PRODUCT_ITEM";

    private static final List<CatalogGroup> catalogGroups = new ArrayList<CatalogGroup>();

    private static final List<ProductItem> orderCart = new ArrayList<ProductItem>();

    static {
        CatalogGroup group = new CatalogGroup(110, "Toro Push Mowers", R.drawable.pk_toro_logo);
        catalogGroups.add(group);

        ProductItem item = new ProductItem(generateId(), "K10476852", "Pinion Bevel Gear", new BigDecimal("26.75"));
        group.addProduct(item);
        item.setSpecial(true);

        item = new ProductItem(generateId(), "T03042819", "Roadlight Kit", new BigDecimal("1406.00"));
        group.addProduct(item);

        item = new ProductItem(generateId(), "T11018930", "Catcher Assembly For 20668 Domestc", new BigDecimal("309.10"));
        group.addProduct(item);

        item = new ProductItem(generateId(), "T14252330", "Drive Sprocket 21 Inch Walk Behind", new BigDecimal("250.60"));
        group.addProduct(item);

        item = new ProductItem(generateId(), "T15124530", "Vacuum-Bag", new BigDecimal("73.60"));
        group.addProduct(item);

        item = new ProductItem(generateId(), "T20013010", "Toro Power Walk Mower Personal Pace", new BigDecimal("799.00"));
        group.addProduct(item);
        item.setSpecial(true);

        item = new ProductItem(generateId(), "T20036010", "Toro Walk Power Mower Commercial Personal Pace", new BigDecimal("1243.00"));
        group.addProduct(item);

        item = new ProductItem(generateId(), "T21040010", "Battery Mower 50mHz 230/240 volt charge System", new BigDecimal("1494.88"));
        group.addProduct(item);

        item = new ProductItem(generateId(), "T22151010", "21 Self Propelled Walk Mower", new BigDecimal("1765.40"));
        group.addProduct(item);

        item = new ProductItem(generateId(), "T35783030", "LH Plate", new BigDecimal("160.55"));
        group.addProduct(item);

        // group
        group = new CatalogGroup(120, "Toro Riding Mowers", R.drawable.pk_toro_logo);
        catalogGroups.add(group);

        item = new ProductItem(generateId(), "T02005110", "Toro Walk Power Mower Personal Pace Electric Start", new BigDecimal("888.00"));
        group.addProduct(item);
        item.setSpecial(true);

        item = new ProductItem(generateId(), "T07124110", "Toro 1638HXL Riding Mower with 38in Cutting Deck", new BigDecimal("4400.00"));
        group.addProduct(item);

        item = new ProductItem(generateId(), "T07124310", "Toro Wheelhorse 1738hxl Ride-on Mower", new BigDecimal("4346.00"));
        group.addProduct(item);

        item = new ProductItem(generateId(), "T07128510", "Toro Wheelhorse 1844hxl Ride-on Mower", new BigDecimal("5235.56"));
        group.addProduct(item);

        item = new ProductItem(generateId(), "T07417010", "Toro Wheelhorse Direct Collect 17hp", new BigDecimal("6213.00"));
        group.addProduct(item);

        item = new ProductItem(generateId(), "T07419010", "Toro Wheelhorse Direct Collect 19 hp", new BigDecimal("6999.00"));
        group.addProduct(item);
        item.setSpecial(true);

        item = new ProductItem(generateId(), "T10231230", "Pulley and Hub Assembly", new BigDecimal("109.99"));
        group.addProduct(item);

        item = new ProductItem(generateId(), "T10274230", "Belt - Deck 52 inch Deck", new BigDecimal("42.99"));
        group.addProduct(item);

        item = new ProductItem(generateId(), "T10397830", "Spindle Shaft and Pulley", new BigDecimal("127.99"));
        group.addProduct(item);

        // group
        group = new CatalogGroup(200, "Toro ZTR Mower", R.drawable.pk_toro_logo);
        catalogGroups.add(group);

        item = new ProductItem(generateId(), "F37059230", "Adaptor - Gear Box Spacer", new BigDecimal("101.75"));
        group.addProduct(item);
        item.setSpecial(true);

        item = new ProductItem(generateId(), "F40061330", "Buzzer Assembly", new BigDecimal("250.75"));
        group.addProduct(item);

        item = new ProductItem(generateId(), "F40061930", "Hour Meter", new BigDecimal("3190.99"));
        group.addProduct(item);

        item = new ProductItem(generateId(), "O12ZT1416", "Quick Vac for Toro 147", new BigDecimal("2700.00"));
        group.addProduct(item);

        item = new ProductItem(generateId(), "T07441219", "Toro Z Master 400 with 20 hp and 44\" Deck", new BigDecimal("13288.99"));
        group.addProduct(item);

        item = new ProductItem(generateId(), "F97081716", "Blades Belts and Filters Set Gianni Ferrari", new BigDecimal("705.99"));
        group.addProduct(item);
        item.setSpecial(true);

        item = new ProductItem(generateId(), "T10024430", "Air Cleaner-Z 355", new BigDecimal("154.99"));
        group.addProduct(item);

        item = new ProductItem(generateId(), "T10039030", "Pulley & Hub", new BigDecimal("54.99"));
        group.addProduct(item);

        item = new ProductItem(generateId(), "T10314030", "Cutter Housing complete", new BigDecimal("408.99"));
        group.addProduct(item);

        item = new ProductItem(generateId(), "T10387030", "Rear Engine Mounte", new BigDecimal("140.99"));
        group.addProduct(item);

        // group
        group = new CatalogGroup(230, "Toro Utility Vehicles", R.drawable.pk_toro_logo);
        catalogGroups.add(group);

        item = new ProductItem(generateId(), "T00721028", "Workman 3100", new BigDecimal("2599.99"));
        group.addProduct(item);
        item.setSpecial(true);

        item = new ProductItem(generateId(), "T00720528", "Workman 3300", new BigDecimal("31122.99"));
        group.addProduct(item);

        item = new ProductItem(generateId(), "T00725922", "Electric box lift", new BigDecimal("1241.99"));
        group.addProduct(item);

        item = new ProductItem(generateId(), "T00730328", "Full Bed Folding Sides", new BigDecimal("1316.00"));
        group.addProduct(item);

        item = new ProductItem(generateId(), "T00732128", "Flat Bed 2/3", new BigDecimal("1818.00"));
        group.addProduct(item);

        item = new ProductItem(generateId(), "T00732228", "Bed Side Kits  2/3", new BigDecimal("999.99"));
        group.addProduct(item);
        item.setSpecial(true);

        item = new ProductItem(generateId(), "T00739928", "Auxiliary Power Unit (Gas) for Pro-control Spray Unit", new BigDecimal("583.00"));
        group.addProduct(item);

        item = new ProductItem(generateId(), "T00740128", "Auxiliary Power Unit Front Pro-control Spray Unit", new BigDecimal("389.99"));
        group.addProduct(item);

        item = new ProductItem(generateId(), "T00740228", "Auxillary Power Unit", new BigDecimal("399.99"));
        group.addProduct(item);

        item = new ProductItem(generateId(), "T00741528", "Remote Hydraulic Control Assembly", new BigDecimal("1211.00"));
        group.addProduct(item);

        item = new ProductItem(generateId(), "T00741628", "Hand Throttle Governor Control", new BigDecimal("390.00"));
        group.addProduct(item);

        // group
        group = new CatalogGroup(235, "Toro Landscape Irrigation", R.drawable.pk_toro_logo);
        catalogGroups.add(group);

        item = new ProductItem(generateId(), "T00721028", "Workman 3100", new BigDecimal("2599.99"));
        group.addProduct(item);
        item.setSpecial(true);

        item = new ProductItem(generateId(), "A11216067", "Model 12P Part Circle Sprinkler", new BigDecimal("17.33"));
        group.addProduct(item);

        item = new ProductItem(generateId(), "A11220067", "Pope Model S600 Gear Drive Sprinkler", new BigDecimal("47.33"));
        group.addProduct(item);

        item = new ProductItem(generateId(), "A11230076", "Ultra Flow 20mm Solenoid Valve", new BigDecimal("44.00"));
        group.addProduct(item);

        item = new ProductItem(generateId(), "A11231267", "19mm Mini-Barb Solenoid Valve", new BigDecimal("36.00"));
        group.addProduct(item);

        item = new ProductItem(generateId(), "A11259467", "Controller Power Pack 240/24V 1 AMP", new BigDecimal("40.00"));
        group.addProduct(item);

        item = new ProductItem(generateId(), "A11267067", "Valve Box Rectangular 300 x 430 x160h", new BigDecimal("37.99"));
        group.addProduct(item);

        item = new ProductItem(generateId(), "A11267767", "Valve Box Lid To Suit 2670", new BigDecimal("18.90"));
        group.addProduct(item);

        item = new ProductItem(generateId(), "A11300667", "Rainspray 235 Fitted With #10 Nozzle", new BigDecimal("205.00"));
        group.addProduct(item);

        item = new ProductItem(generateId(), "A11330176", "Century 40mm Solenoid Valve With Flow Control", new BigDecimal("205.00"));
        group.addProduct(item);

        // group
        group = new CatalogGroup(255, "Bush Hog", R.drawable.pk_bush_hog_logo);
        catalogGroups.add(group);

        item = new ProductItem(generateId(), "H06466331", "Cross & Bearing Kit", new BigDecimal("210.00"));
        group.addProduct(item);

        item = new ProductItem(generateId(), "H07001531", "Gearbox", new BigDecimal("1026.99"));
        group.addProduct(item);

        item = new ProductItem(generateId(), "H07028731", "Hexagon Nut", new BigDecimal("39.99"));
        group.addProduct(item);

        item = new ProductItem(generateId(), "H08867131", "Idler Arm Assy", new BigDecimal("288.68"));
        group.addProduct(item);

        item = new ProductItem(generateId(), "H50017131", "Roller Assembly", new BigDecimal("148.12"));
        group.addProduct(item);

        item = new ProductItem(generateId(), "H51740731", "Belts-Matched Set", new BigDecimal("292.55"));
        group.addProduct(item);

        item = new ProductItem(generateId(), "H76471031", "Outer Yoke", new BigDecimal("19.99"));
        group.addProduct(item);

        item = new ProductItem(generateId(), "HRDTH7231", "Bush Hog Rear Discharge Finishing Mower 72\"", new BigDecimal("5421.00"));
        group.addProduct(item);

        // group
        group = new CatalogGroup(260, "Lastec Mowers", R.drawable.pk_lastec_logo);
        catalogGroups.add(group);

        item = new ProductItem(generateId(), "L01890036", "Deck Hinge Pin", new BigDecimal("73.30"));
        group.addProduct(item);

        item = new ProductItem(generateId(), "L425HD036", "Articulator 425D", new BigDecimal("29900.00"));
        group.addProduct(item);

        item = new ProductItem(generateId(), "LA1500L36", "9 inch Wheel Assembly - Lastec", new BigDecimal("276.25"));
        group.addProduct(item);

        item = new ProductItem(generateId(), "LA2310L36", "Right Wheel Arm", new BigDecimal("1242.21"));
        group.addProduct(item);

        item = new ProductItem(generateId(), "LB6000L36", "Belt - Drive Lastec", new BigDecimal("42.97"));
        group.addProduct(item);

        item = new ProductItem(generateId(), "LK3200L36", "Decal Kit Lastec Model 721-X", new BigDecimal("205.84"));
        group.addProduct(item);

        item = new ProductItem(generateId(), "LP1100L36", "Clevis Pin Lastec", new BigDecimal("3.28"));
        group.addProduct(item);

        // group
        group = new CatalogGroup(280, "National Mowers", R.drawable.pk_national_logo);
        catalogGroups.add(group);

        item = new ProductItem(generateId(), "N03901039", "Belt Counter Shaft", new BigDecimal("72.33"));
        group.addProduct(item);

        item = new ProductItem(generateId(), "N03908039", "Belt Main Mower Clutch", new BigDecimal("183.64"));
        group.addProduct(item);

        item = new ProductItem(generateId(), "N03931039", "Belts Wing Mower", new BigDecimal("47.99"));
        group.addProduct(item);

        item = new ProductItem(generateId(), "N04502039", "Shifter Lever Spring", new BigDecimal("35.48"));
        group.addProduct(item);

        item = new ProductItem(generateId(), "N06035039", "Bush-National", new BigDecimal("57.59"));
        group.addProduct(item);

        item = new ProductItem(generateId(), "N06104039", "Ball Bearing National 68 inch", new BigDecimal("303.34"));
        group.addProduct(item);

        item = new ProductItem(generateId(), "N06109039", "Pillowblock Countershaft National 76 inch", new BigDecimal("226.99"));
        group.addProduct(item);

        item = new ProductItem(generateId(), "N07032039", "Chain Assembly National 76 inch", new BigDecimal("104.03"));
        group.addProduct(item);

        // group
        group = new CatalogGroup(285, "Exmark Mowers", R.drawable.pk_exmark_logo);
        catalogGroups.add(group);

        item = new ProductItem(generateId(), "K24290152", "Oil Filter Adapter", new BigDecimal("134.99"));
        group.addProduct(item);

        item = new ProductItem(generateId(), "T00013916", "Bearing Kit Hydraulic Motor", new BigDecimal("2965.00"));
        group.addProduct(item);

        item = new ProductItem(generateId(), "T10300530", "Muffler", new BigDecimal("567.00"));
        group.addProduct(item);

        item = new ProductItem(generateId(), "T13028016", "Jackshaft-Housing", new BigDecimal("138.64"));
        group.addProduct(item);

        item = new ProductItem(generateId(), "T13122416", "Wheel /Tyre Assy(also 103-2171)", new BigDecimal("194.30"));
        group.addProduct(item);

        item = new ProductItem(generateId(), "T13158016", "Blade - Excalibur blade, solid 20.50", new BigDecimal("51.80"));
        group.addProduct(item);

        item = new ProductItem(generateId(), "T13210816", "Diesel cap-superceded to 103-3991", new BigDecimal("46.12"));
        group.addProduct(item);

        item = new ProductItem(generateId(), "T13248916", "XP Wheel Motor", new BigDecimal("1756.00"));
        group.addProduct(item);

        // group
        group = new CatalogGroup(300, "Standard Golf Accessories", R.drawable.pk_standardgolf_accessories_logo);
        catalogGroups.add(group);

        item = new ProductItem(generateId(), "S01150049", "Duo Rake-Natural aluminium handle", new BigDecimal("34.00"));
        group.addProduct(item);

        item = new ProductItem(generateId(), "S01303049", "Lid Assembly Ball Washer", new BigDecimal("31.99"));
        group.addProduct(item);

        item = new ProductItem(generateId(), "S01325049", "Ball Washer Red", new BigDecimal("385.00"));
        group.addProduct(item);

        item = new ProductItem(generateId(), "S01350049", "Ball Washer Green", new BigDecimal("385.00"));
        group.addProduct(item);

        item = new ProductItem(generateId(), "S01450049", "Premier ball washer-Green", new BigDecimal("452.99"));
        group.addProduct(item);

        item = new ProductItem(generateId(), "S02800049", "Standard Golf Turfmaster Holecutter", new BigDecimal("717.50"));
        group.addProduct(item);

        item = new ProductItem(generateId(), "S04969049", "Tee Towel Economy", new BigDecimal("193.00"));
        group.addProduct(item);

        // group
        group = new CatalogGroup(400, "Kohler", R.drawable.pk_kohler_logo);
        catalogGroups.add(group);

        item = new ProductItem(generateId(), "G173FFF50", "Lifan 8hp  1\"  Q Shaft Engine, Tank, Ctrls, Muffler", new BigDecimal("883.00"));
        group.addProduct(item);

        item = new ProductItem(generateId(), "K12000252", "Gauze Filter Assembly", new BigDecimal("59.90"));
        group.addProduct(item);

        item = new ProductItem(generateId(), "K12025552", "Flywheel", new BigDecimal("365.80"));
        group.addProduct(item);

        item = new ProductItem(generateId(), "K12040252", "Crankshaft Assembly", new BigDecimal("559.99"));
        group.addProduct(item);

        item = new ProductItem(generateId(), "K12060152", "Exhaust Valve", new BigDecimal("64.00"));
        group.addProduct(item);

        item = new ProductItem(generateId(), "K12068252", "Muffler CV Spec 1206 Floor Polisher", new BigDecimal("247.50"));
        group.addProduct(item);

        item = new ProductItem(generateId(), "K12070552", "Connecting Rod Standard", new BigDecimal("131.80"));
        group.addProduct(item);

        // group
        group = new CatalogGroup(500, "Pope DIY Irrigation", R.drawable.pk_pope_logo);
        catalogGroups.add(group);

        item = new ProductItem(generateId(), "P10001B64", "20mm BSP Nut and 13mm Tail - Barcoded Bulk", new BigDecimal("1.11"));
        group.addProduct(item);

        item = new ProductItem(generateId(), "P10100864", "Rotoframe On Base", new BigDecimal("20.80"));
        group.addProduct(item);

        item = new ProductItem(generateId(), "P10103764", "Impact Sled - 1 Per Blister", new BigDecimal("16.90"));
        group.addProduct(item);

        item = new ProductItem(generateId(), "P10128464", "Impact in Cannister", new BigDecimal("26.90"));
        group.addProduct(item);

        item = new ProductItem(generateId(), "P10129064", "Single Stream  Gear Drive With Adj. Nozzle", new BigDecimal("45.10"));
        group.addProduct(item);

        item = new ProductItem(generateId(), "P10130564", "Gemini- 2 in 1 Tap Timer", new BigDecimal("94.00"));
        group.addProduct(item);

        item = new ProductItem(generateId(), "P10130664", "EasyPro-Automatic Tap timer", new BigDecimal("71.90"));
        group.addProduct(item);

        item = new ProductItem(generateId(), "P10132464", "Rain Switch", new BigDecimal("79"));
        group.addProduct(item);

    }

    private static long PROD_ID = 1;

    /**
     * simulate db id
     */
    private static long generateId() {
        return PROD_ID++;
    }

    public static List<CatalogGroup> getCatalogGroups() {
        return Collections.unmodifiableList(catalogGroups);
    }

    public static ProductItem getProductById(final long id) {
        for (final CatalogGroup catalogGroup : catalogGroups) {
            for (final ProductItem productItem : catalogGroup.getProducts()) {
                if (productItem.getId() == id) {
                    return productItem;
                }
            }
        }
        return null;
    }

    public static List<ProductItem> getOrderCart() {
        return Collections.unmodifiableList(orderCart);
    }

    public boolean hasOrder() {
        return orderCart.size() > 0;
    }

    public static void addOrder(final ProductItem selectedProduct) {
        final ProductItem productItem = getProductById(selectedProduct.getId());
        if (productItem == null) {
            return;
        }

        productItem.setQuantity(selectedProduct.getQuantity());
        if (!orderCart.contains(productItem)) {
            if (selectedProduct.getQuantity() > 0) {
                orderCart.add(productItem);
            }
        }
        else {
            if (selectedProduct.getQuantity() <= 0) {
                // the quantity has been reset to 0, remove this product from orders
                orderCart.remove(productItem);
            }
        }
    }

    public static void clearOrders() {
        for (final ProductItem product : orderCart) {
            product.setQuantity(0);
        }
        orderCart.clear();
    }

    public static boolean hasOrders() {
        return !orderCart.isEmpty();
    }

    public static int getNumberOfOrder() {
        return orderCart.size();
    }

    public static void deleteOrder(final ProductItem productItem) {
        if (orderCart.contains(productItem)) {
            orderCart.remove(productItem);
            productItem.setQuantity(0);
        }
    }

    public static List<ProductItem> getSpecialOfferProducts() {
        final List<ProductItem> items = new ArrayList<ProductItem>();

        for (final CatalogGroup catalogGroup : catalogGroups) {
            for (final ProductItem productItem : catalogGroup.getProducts()) {
                if (productItem.isSpecial()) {
                    items.add(productItem);
                }
            }
        }

        return Collections.unmodifiableList(items);
    }

    private static CatalogGroup getGroupById(final int id) {
        for (final CatalogGroup group : catalogGroups) {
            if (group.getId() == id) {
                return group;
            }
        }
        return null;
    }

    public static List<ProductItem> searchProduct(final CatalogGroup selectedCatalogGroup, final ProductFieldFilter productFieldFilter, final String searchText) {
        final List<CatalogGroup> searchGroups = selectedCatalogGroup == null || selectedCatalogGroup.getId() <= 0 ? catalogGroups : Collections
                .singletonList(getGroupById(selectedCatalogGroup.getId()));

        final List<ProductItem> result = new ArrayList<ProductItem>();

        for (final CatalogGroup catalogGroup : searchGroups) {

            for (final ProductItem productItem : catalogGroup.getProducts()) {
                switch (productFieldFilter) {
                    case ALL:
                        if (productItem.matchInventoryId(searchText) || productItem.matchProductDescription(searchText)) {
                            result.add(productItem);
                        }
                        break;
                    case INVENTORY_ID:
                        if (productItem.matchInventoryId(searchText)) {
                            result.add(productItem);
                        }
                        break;
                    case NAME:
                        if (productItem.matchProductDescription(searchText)) {
                            result.add(productItem);
                        }
                        break;
                    default:

                }

            }

        }

        return result;
    }
}
