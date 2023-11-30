import DAO.CategoryDAO;
import DAO.ProductDAO;
import Model.Category;
import Model.Product;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Category> categories = new ArrayList<>();

        categories.add( new Category(2, "Prescription Medications", "Prescription Drugs", 0));
        categories.add( new Category(3, "Over-the-Counter Medications", "OTC Drugs", 0));
        categories.add(  new Category(4, "Personal Care Products", "Personal Care Items", 0));
        categories.add(  new Category(5, "Vitamins and Supplements", "Vitamins and Dietary Supplements", 0));
        categories.add(  new Category(6, "First Aid", "First Aid Supplies", 0));
        categories.add(  new Category(7, "Antibiotics", "Prescription Antibiotics", 2));
        categories.add(  new Category(8, "Pain Relief", "Prescription Pain Medications", 2));
        categories.add(  new Category(9, "Pain Relievers", "Over-the-Counter Pain Medications", 3));
        categories.add(  new Category(10, "Cough and Cold Medications", "OTC Cough and Cold Medications", 3));
        categories.add(  new Category(11, "Digestive Health", "OTC Digestive Health Products", 3));
        categories.add(  new Category(12, "Skincare", "Personal Care Skincare Products", 4));
        categories.add(  new Category(13, "Hair Care", "Personal Care Hair Care Products", 4));
        categories.add(  new Category(14, "Oral Care", "Personal Care Oral Care Products", 4));
        categories.add(  new Category(15, "Multivitamins", "Various Multivitamin Supplements", 5));
        categories.add(  new Category(16, "Omega-3 and Fish Oils", "Omega-3 Fatty Acids Supplements", 5));
        categories.add(  new Category(17, "Herbal Supplements", "Herbal Dietary Supplements", 5));
        categories.add(  new Category(18, "Bandages", "Various Types of Bandages", 6));
        categories.add(  new Category(19, "Wound Care", "Products for Wound Care", 6));
        categories.add(  new Category(20, "Topical Pain Relief", "Topical Pain Relief Products", 9));

        List<Product> products = new ArrayList<>();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        try {
            // Creating instances of products and associating them with categories
            products.add(new Product(101, "Amoxicillin", 15.99, 1, 30, 30, dateFormat.parse("2023-12-01"), "Broad-spectrum antibiotic", 7));
            products.add(new Product(102, "Ibuprofen", 8.49, 24, 48, 1152,  dateFormat.parse("2024-02-01"), "Pain reliever", 9));
            products.add(new Product(103, "Vitamin C", 12.95, 1, 90, 90,  dateFormat.parse("2023-11-15"), "Immune system support", 15));

            // Adding more products...
            products.add(new Product(104, "Aspirin", 5.99, 10, 5, 50,  dateFormat.parse("2024-03-01"), "Pain reliever", 9));
            products.add(new Product(105, "Paracetamol", 3.99, 10, 10, 100,  dateFormat.parse("2024-01-15"), "Fever reducer", 9));
            products.add(new Product(106, "Cetirizine", 9.95, 10, 8,80, dateFormat.parse("2023-12-10"), "Antihistamine", 10));
            products.add(new Product(107, "Loperamide", 7.49, 12, 6,72, dateFormat.parse("2024-02-28"), "Anti-diarrheal", 11));
            products.add(new Product(108, "Antacid", 4.99, 1, 30,30, dateFormat.parse("2023-12-20"), "Acid reflux relief", 11));
            products.add(new Product(109, "Moisturizing Cream", 14.99, 1, 20,20, dateFormat.parse("2024-04-01"), "Hydrating skin cream", 12));
            products.add(new Product(110, "Shampoo", 6.95, 1, 24,24,dateFormat.parse( "2024-03-15"), "Cleansing shampoo", 13));
            products.add(new Product(111, "Toothpaste", 2.99, 1, 36,36,dateFormat.parse( "2024-01-01"), "Fluoride toothpaste", 14));
            products.add(new Product(112, "Multivitamin Gummies", 19.99, 30, 2,60, dateFormat.parse("2023-12-31"), "Tasty multivitamin", 15));
            products.add(new Product(113, "Fish Oil Capsules", 25.49, 60, 3,180, dateFormat.parse("2024-02-10"), "Omega-3 supplement", 16));
            products.add(new Product(114, "Echinacea Extract", 8.95, 1, 50,50,dateFormat.parse( "2024-01-20"), "Immune support", 17));
            products.add(new Product(115, "Adhesive Bandages", 3.49, 10, 10,100,dateFormat.parse( "2024-03-05"), "Minor wound care", 18));
            products.add(new Product(116, "Hydrocolloid Dressing", 6.99, 5, 8,40, dateFormat.parse("2024-04-15"), "Advanced wound care", 19));
            products.add(new Product(117, "Pain Relief Cream", 12.75, 1, 15,15, dateFormat.parse("2023-12-15"), "Topical pain relief", 20));
            products.add(new Product(118, "Naproxen Sodium", 9.99, 20, 3,60, dateFormat.parse("2024-03-25"), "Anti-inflammatory", 9));
            products.add(new Product(119, "Allergy Relief Tablets", 14.49, 30, 5,150, dateFormat.parse("2024-04-10"), "Antihistamine", 10));
            products.add(new Product(120, "Pepto-Bismol", 7.25, 1, 25,25, dateFormat.parse("2024-02-15"), "Digestive relief", 11));
            products.add(new Product(121, "Aloe Vera Gel", 6.99, 1, 15,15, dateFormat.parse("2024-05-01"), "Skin soothing gel", 12));
            products.add(new Product(122, "Conditioner", 5.95, 1, 30,30,dateFormat.parse( "2024-04-20"), "Hair conditioning", 13));
            products.add(new Product(123, "Mouthwash", 3.49, 1, 25,25, dateFormat.parse("2024-02-28"), "Antiseptic mouthwash", 14));
            products.add(new Product(124, "Calcium Supplements", 18.99, 60, 2,120,dateFormat.parse( "2024-03-10"), "Bone health", 15));
            products.add(new Product(125, "Vitamin D Capsules", 12.75, 30, 3,90,dateFormat.parse( "2024-04-05"), "Sunshine vitamin", 16));
            products.add(new Product(126, "Ginger Capsules", 11.49, 60, 2,120, dateFormat.parse("2024-05-15"), "Digestive aid", 17));
            products.add(new Product(127, "Flexible Fabric Bandages", 4.75, 10, 8,80,dateFormat.parse( "2024-06-01"), "Comfortable bandages", 18));
            products.add(new Product(128, "Antiseptic Ointment", 6.25, 1, 20,20,dateFormat.parse( "2024-05-20"), "First aid ointment", 19));
            products.add(new Product(129, "Cold Sore Cream", 8.99, 1, 15,15, dateFormat.parse("2024-06-10"), "Fever blister treatment", 20));
            products.add(new Product(130, "Shower Gel", 7.49, 1, 18,18, dateFormat.parse("2024-07-01"), "Refreshing shower gel", 13));
            products.add(new Product(131, "Toothbrush", 2.25, 1, 10,10, dateFormat.parse("2024-06-15"), "Soft bristle toothbrush", 14));
            products.add(new Product(132, "Children's Multivitamins", 16.99, 60, 2,120, dateFormat.parse("2024-07-10"), "Kids' health", 15));
            products.add(new Product(133, "Omega-3 Softgels", 21.95, 90, 2,180,dateFormat.parse( "2024-08-01"), "Heart health", 16));
            products.add(new Product(134, "Turmeric Supplements", 10.49, 30, 4,120,dateFormat.parse( "2024-07-15"), "Anti-inflammatory", 17));
            products.add(new Product(135, "Sports Tape", 5.99, 1, 12,12, dateFormat.parse("2024-08-10"), "Athletic support", 18));
            products.add(new Product(136, "Hydrogen Peroxide", 2.75, 1, 24,24, dateFormat.parse("2024-09-01"), "Antiseptic solution", 19));
            products.add(new Product(137, "Sunscreen SPF 30", 13.49, 1, 15,15, dateFormat.parse("2024-08-15"), "UV protection", 12));
            products.add(new Product(138, "Cough Syrup", 9.99, 1, 20,20, dateFormat.parse("2024-09-15"), "Cough and cold relief", 10));
            products.add(new Product(139, "Laxative Tablets", 7.49, 30, 3,90, dateFormat.parse("2024-10-01"), "Gentle constipation relief", 11));
            products.add(new Product(140, "Lip Balm", 3.25, 1, 25,25,dateFormat.parse( "2024-09-20"), "Moisturizing lip care", 12));
            products.add(new Product(141, "Hair Serum", 11.95, 1, 15,15, dateFormat.parse("2024-10-10"), "Frizz control", 13));
            products.add(new Product(142, "Mouth Ulcer Gel", 5.99, 1, 10,10, dateFormat.parse("2024-10-25"), "Oral ulcer relief", 14));
            products.add(new Product(143, "Iron Supplements", 15.49, 60, 2,120, dateFormat.parse("2024-11-01"), "Supports iron levels", 15));
            products.add(new Product(144, "Probiotic Capsules", 18.75, 30, 2,60,dateFormat.parse( "2024-11-15"), "Gut health", 16));
            products.add(new Product(145, "Chamomile Tea Bags", 4.49, 20, 3,60,dateFormat.parse( "2024-11-30"), "Calming herbal tea", 17));
            products.add(new Product(146, "Knee Support Brace", 14.99, 1, 8,8,dateFormat.parse( "2024-12-10"), "Joint stability", 18));
            products.add(new Product(147, "Antifungal Cream", 8.25, 1, 15,15,dateFormat.parse( "2024-12-25"), "Fungal infection relief", 19));
            products.add(new Product(148, "Hand Sanitizer", 2.99, 1, 30,30,dateFormat.parse( "2025-01-01"), "Disinfectant gel", 6));
            products.add(new Product(149, "Anti-Acne Face Wash", 6.49, 1, 25,25, dateFormat.parse("2025-01-15"), "Acne treatment", 12));
            products.add(new Product(150, "Joint Pain Relief Gel", 12.95, 1, 20,20,dateFormat.parse( "2025-02-01"), "Topical pain relief", 20));
            products.add(new Product(151, "Energy Drink", 2.79, 1, 24,24,dateFormat.parse( "2025-02-15"), "Boosts energy levels", 5));
            products.add(new Product(152, "Dental Floss", 1.99, 1, 30,30, dateFormat.parse("2025-03-01"), "Oral hygiene", 14));
            products.add(new Product(153, "Fiber Supplements", 9.49, 60, 2,120, dateFormat.parse("2025-03-15"), "Digestive health", 15));
            products.add(new Product(154, "Motion Sickness Tablets", 6.99, 30, 3,90, dateFormat.parse("2025-03-30"), "Relief from motion sickness", 10));
            products.add(new Product(155, "Hand Cream", 5.25, 1, 25,25, dateFormat.parse("2025-04-01"), "Moisturizing hand cream", 12));
            products.add(new Product(156, "Dandruff Shampoo", 7.95, 1, 20,20, dateFormat.parse("2025-04-15"), "Controls dandruff", 13));
            products.add(new Product(157, "Throat Lozenges", 4.49, 20, 4,80, dateFormat.parse("2025-04-30"), "Soothes sore throat", 10));
            products.add(new Product(158, "Calcium Chewable Tablets", 11.99, 30, 2,60,dateFormat.parse( "2025-05-01"), "Calcium supplement", 15));
            products.add(new Product(159, "Digestive Enzyme Supplements", 15.75, 60, 2,120, dateFormat.parse("2025-05-15"), "Aids digestion", 11));
            products.add(new Product(160, "Green Tea Extract Capsules", 13.49, 30, 3,90,dateFormat.parse( "2025-05-30"), "Antioxidant support", 17));
            products.add(new Product(161, "Elbow Support Brace", 17.99, 1, 10,10, dateFormat.parse("2025-06-01"), "Provides elbow support", 18));
            products.add(new Product(162, "Anti-Itch Cream", 8.49, 1, 15,15, dateFormat.parse("2025-06-15"), "Relieves itching", 19));
            products.add(new Product(163, "Nasal Decongestant Spray", 6.25, 1, 20,20,dateFormat.parse( "2025-06-30"), "Relieves nasal congestion", 10));
            products.add(new Product(164, "Mint Toothpaste", 3.75, 1, 25,25, dateFormat.parse("2025-07-01"), "Freshens breath", 14));
            products.add(new Product(165, "Vitamin E Oil", 14.95, 1, 15,15,dateFormat.parse( "2025-07-15"), "Nourishes skin", 12));
            products.add(new Product(166, "Sleep Aid Tablets", 10.99, 30, 2,60,dateFormat.parse( "2025-07-30"), "Promotes sleep", 10));
            products.add(new Product(167, "Hair Growth Serum", 19.49, 1, 12,12,dateFormat.parse( "2025-08-01"), "Stimulates hair growth", 13));
            products.add(new Product(168, "Natural Mouthwash", 5.99, 1, 20,20, dateFormat.parse("2025-08-15"), "Alcohol-free mouthwash", 14));
            products.add(new Product(169, "Vitamin B Complex Capsules", 12.49, 60, 2,120, dateFormat.parse("2025-08-30"), "Energy and metabolism support", 15));
            products.add(new Product(170, "Joint and Muscle Rub", 7.95, 1, 18,18, dateFormat.parse("2025-09-01"), "Soothing relief for joints and muscles", 20));
            products.add(new Product(171, "Fruit Flavored Antacid Tablets", 4.25, 30, 3,90,dateFormat.parse( "2025-09-15"), "Heartburn relief", 11));
            products.add(new Product(172, "Dental Mouthguard", 8.99, 1, 10,10,dateFormat.parse( "2025-09-30"), "Nighttime teeth grinding protection", 14));
            products.add(new Product(173, "Cooling Eye Drops", 6.49, 1, 15,15,dateFormat.parse( "2025-10-01"), "Relieves dry and tired eyes", 12));
            products.add(new Product(174, "Collagen Supplements", 21.99, 90, 2,180,dateFormat.parse( "2025-10-15"), "Supports skin elasticity", 16));
            products.add(new Product(175, "Hemorrhoid Cream", 9.75, 1, 20,20,dateFormat.parse( "2025-10-30"), "Relief from hemorrhoid discomfort", 11));
            products.add(new Product(176, "Folic Acid Tablets", 5.49, 60, 2,120,dateFormat.parse( "2025-11-01"), "Supports cell division", 15));
            products.add(new Product(177, "Aromatherapy Essential Oils", 16.95, 1, 12,12,dateFormat.parse( "2025-11-15"), "Promotes relaxation", 17));
            products.add(new Product(178, "Compression Socks", 11.49, 1, 15,15,dateFormat.parse( "2025-11-30"), "Improves circulation", 18));
            products.add(new Product(179, "Anti-Wrinkle Cream", 13.99, 1, 18,18,dateFormat.parse( "2025-12-01"), "Reduces signs of aging", 12));
            products.add(new Product(180, "Cranberry Supplements", 7.25, 30, 3,90,dateFormat.parse( "2025-12-15"), "Urinary tract health", 15));
            categories.add( new Category(21, "Eye Care", "Products for eye health", 0));
            categories.add( new Category(22, "Sleep Aids", "Aids for promoting sleep", 0));
            categories.add( new Category(23, "Digestive Enzymes", "Enzymes for digestive health", 5));
            categories.add( new Category(24, "Extra Strength Pain Relief", "High potency topical pain relief", 9));
            categories.add( new Category(25, "Immune Boosters", "Boosts immune system", 15));
            categories.add( new Category(26, "Essential Oils", "Aromatherapy essential oils", 17));
            categories.add( new Category(27, "Diabetic Care", "Products for diabetic health", 0));
            categories.add( new Category(28, "Hair Loss Treatments", "Treatments for hair loss", 13));
            categories.add( new Category(29, "Weight Management", "Products for weight control", 5));
            categories.add( new Category(30, "Prenatal Vitamins", "Vitamins for expectant mothers", 15));
            products.add(new Product(181, "Preservative-Free Eye Drops", 8.95, 1, 15,15,dateFormat.parse( "2025-12-30"), "Relieves dry eyes", 21));
            products.add(new Product(182, "Melatonin Tablets", 6.49, 30, 3,90, dateFormat.parse("2026-01-01"), "Natural sleep aid", 22));
            products.add(new Product(183, "Digestive Enzyme Blend", 14.99, 60, 2,120, dateFormat.parse("2026-01-15"), "Supports digestion", 23));
            products.add(new Product(184, "Extra Strength Pain Relief Cream", 16.75, 1, 20,20, dateFormat.parse("2026-02-01"), "Powerful topical pain relief", 24));
            products.add(new Product(185, "Vitamin C + Zinc Tablets", 11.49, 30, 2,60, dateFormat.parse("2026-02-15"), "Boosts immune system", 25));
            products.add(new Product(186, "Lavender Essential Oil", 9.99, 1, 15,15,dateFormat.parse( "2026-03-01"), "Calming aroma", 26));
            products.add(new Product(187, "Blood Glucose Monitor", 29.95, 1, 10,10,dateFormat.parse( "2026-03-15"), "Monitor for diabetic care", 27));
            products.add(new Product(188, "Hair Regrowth Foam", 22.49, 1, 15,15,dateFormat.parse( "2026-04-01"), "Promotes hair regrowth", 28));
            products.add(new Product(189, "Meal Replacement Shake", 17.99, 1, 12,12,dateFormat.parse( "2026-04-15"), "Supports weight management", 29));
            products.add(new Product(190, "Prenatal Multivitamin", 19.95, 60, 2,120, dateFormat.parse("2026-05-01"), "Nutritional support for pregnancy", 30));
            products.add(new Product(191, "Blue Light Blocking Glasses", 12.49, 1, 18,18, dateFormat.parse("2026-05-15"), "Protects eyes from digital strain", 21));
            products.add(new Product(192, "Herbal Sleep Tea", 5.99, 20, 4,80, dateFormat.parse("2026-06-01"), "Natural sleep aid", 22));
            products.add(new Product(193, "Probiotic Gummies", 13.49, 60, 2,120,dateFormat.parse( "2026-06-15"), "Supports gut health", 23));
            products.add(new Product(194, "Arthritis Pain Relief Cream", 18.75, 1, 15,15, dateFormat.parse("2026-07-01"), "Relieves joint pain", 24));
            products.add(new Product(195, "Echinacea Essential Oil", 8.95, 1, 12,12,dateFormat.parse( "2026-07-15"), "Immune system support", 26));
            products.add(new Product(196, "Blood Pressure Monitor", 34.99, 1, 8,8, dateFormat.parse("2026-08-01"), "Monitor for cardiovascular health", 27));
            products.add(new Product(197, "Hair, Skin, and Nails Supplement", 15.49, 30, 3,90,dateFormat.parse( "2026-08-15"), "Supports beauty from within", 28));
            products.add(new Product(198, "Green Tea Weight Loss Capsules", 21.95, 60, 2,120,dateFormat.parse( "2026-09-01"), "Supports weight loss", 29));
            products.add(new Product(199, "Folic Acid for Pregnancy", 11.25, 30, 2,60, dateFormat.parse("2026-09-15"), "Supports fetal development", 30));
            products.add(new Product(200, "Calming Lavender Pillow Spray", 7.49, 1, 20,20,dateFormat.parse( "2026-10-01"), "Promotes relaxation", 26));




        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        for(Category c : categories)
        {
            CategoryDAO.addCategory(c);
        }
        for (Product p : products)
        {
            ProductDAO.addProduct(p);
        }
    }
}
