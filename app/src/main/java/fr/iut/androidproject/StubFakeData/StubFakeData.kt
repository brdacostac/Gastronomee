package fr.iut.androidproject.StubFakeData

import fr.iut.androidproject.model.Category
import fr.iut.androidproject.model.Recette

class StubFakeData {

    private var recommended = mutableListOf<fr.iut.androidproject.model.Recette>()
    private var categories = mutableListOf<fr.iut.androidproject.model.Category>()

    val category1 = Category("1", "SeaFish", "https://cdn-icons-png.flaticon.com/512/199/199669.png")
    val category2 = Category("2", "Dessert", "https://assets.stickpng.com/images/6119528ff8fe340004e0d2ee.png")
    val category3 = Category("3", "Beef", "https://cdn-icons-png.flaticon.com/512/2541/2541030.png")
    val category4 = Category("4", "Vegan", "https://pngimg.com/d/vegan_PNG11.png")


    val recette1 = Recette(
        "1",
        "Seafood Salad",
        "A delicious seafood salad with shrimp, mussels, and squid.",
        "https://sardofoods.ca/wp-content/uploads/2019/08/Shrimp-Salad-2000x1340.png",
        "International",
        "Seafood",
        listOf("Shrimp", "Mussels", "Squid"),
        listOf("200g", "300g", "150g"),
    )

    val recette2 = Recette(
        "2",
        "Strawberry Tart",
        "A delicious homemade strawberry tart.",
        "https://addictedtodates.com/wp-content/uploads/2019/04/vegan-strawberry-tart.jpg",
        "International",
        "Dessert",
        listOf("Strawberries", "Sugar", "Flour"),
        listOf("500g", "100g", "200g")
    )

    val recette3 = Recette(
        "3",
        "Grilled Steak",
        "A juicy and flavorful grilled steak with grilled vegetables.",
        "https://www.foodandwine.com/thmb/5FA-NAln3W2Cmc-N7ydsFlQcOSw=/1500x0/filters:no_upscale():max_bytes(150000):strip_icc()/Mistakes-To-Avoid-When-Grilling-Steak-FT-BLOG0622-2000-9470d6138120449885c7b91524c51cc4.jpg",
        "International",
        "Beef",
        listOf("Steak", "Tomatoes", "Peppers"),
        listOf("1", "2", "2")
    )

    val recette4 = Recette(
        "4",
        "Pasta with Vegetables",
        "Delicious pasta with fresh vegetables.",
        "https://www.funfoodfrolic.com/wp-content/uploads/2021/01/Stir-Fry-Pasta-Thumbnail.jpg",
        "International",
        "Vegan",
        listOf("Pasta", "Broccoli", "Zucchini"),
        listOf("500g", "200g", "200g")
    )

    val recette5 = Recette(
        "5",
        "Shrimp Scampi",
        "A classic Italian shrimp scampi recipe served with spaghetti.",
        "https://sardofoods.ca/wp-content/uploads/2019/08/Shrimp-Salad-2000x1340.png",
        "Italian",
        "SeaFish",
        listOf("Shrimp", "Garlic", "Lemon"),
        listOf("500g", "4 cloves", "1"),
    )

    val recette6 = Recette(
        "6",
        "Salmon and Asparagus",
        "Baked salmon with lemon and garlic served with roasted asparagus.",
        "https://sardofoods.ca/wp-content/uploads/2019/08/Shrimp-Salad-2000x1340.png",
        "American",
        "SeaFish",
        listOf("Salmon fillet", "Asparagus", "Lemon"),
        listOf("500g", "1 bunch", "1"),
    )

    val recette7 = Recette(
        "7",
        "Seafood Chowder",
        "A creamy and hearty seafood chowder made with shrimp, mussels, and cod.",
        "https://sardofoods.ca/wp-content/uploads/2019/08/Shrimp-Salad-2000x1340.png",
        "International",
        "SeaFish",
        listOf("Shrimp", "Mussels", "Cod fillet"),
        listOf("500g", "300g", "500g"),
    )

    val recette8 = Recette(
        "8",
        "Raspberry Cheesecake",
        "A classic cheesecake recipe topped with fresh raspberries.",
        "https://addictedtodates.com/wp-content/uploads/2019/04/vegan-strawberry-tart.jpg",
        "International",
        "Dessert",
        listOf("Cream cheese", "Graham crackers", "Raspberries"),
        listOf("500g", "200g", "250g"),
    )

    val recette9 = Recette(
        "9",
        "Banana Bread",
        "A moist and delicious banana bread recipe.",
        "https://addictedtodates.com/wp-content/uploads/2019/04/vegan-strawberry-tart.jpg",
        "International",
        "Dessert",
        listOf("Bananas", "Flour", "Sugar"),
        listOf("3 ripe", "200g", "150g"),
    )

    val recette10 = Recette(
        "10",
        "Chocolate Mousse",
        "A rich and creamy chocolate mousse recipe.",
        "https://addictedtodates.com/wp-content/uploads/2019/04/vegan-strawberry-tart.jpg",
        "International",
        "Dessert",
        listOf("Dark chocolate", "Eggs", "Whipping cream"),
        listOf("300g", "4", "1 cup"),
    )

    val recette11 = Recette(
        "11",
        "Beef and Mushroom Stir-Fry",
        "A quick and easy beef and mushroom stir-fry with a savory sauce.",
        "https://www.foodandwine.com/thmb/5FA-NAln3W2Cmc-N7ydsFlQcOSw=/1500x0/filters:no_upscale():max_bytes(150000):strip_icc()/Mistakes-To-Avoid-When-Grilling-Steak-FT-BLOG0622-2000-9470d6138120449885c7b91524c51cc4.jpg",
        "Chinese",
        "Beef",
        listOf("Beef sirloin", "Mushrooms", "Green onions"),
        listOf("500g", "200g", "2")
    )

    val recette12 = Recette(
        "12",
        "Beef and Broccoli",
        "A classic Chinese dish of tender beef and crisp broccoli in a savory sauce.",
        "https://www.foodandwine.com/thmb/5FA-NAln3W2Cmc-N7ydsFlQcOSw=/1500x0/filters:no_upscale():max_bytes(150000):strip_icc()/Mistakes-To-Avoid-When-Grilling-Steak-FT-BLOG0622-2000-9470d6138120449885c7b91524c51cc4.jpg",
        "Chinese",
        "Beef",
        listOf("Flank steak", "Broccoli", "Garlic"),
        listOf("500g", "500g", "2 cloves")
    )

    val recette13 = Recette(
        "13",
        "Grilled Lamb Chops",
        "Juicy grilled lamb chops with a rosemary-garlic marinade.",
        "https://www.foodandwine.com/thmb/5FA-NAln3W2Cmc-N7ydsFlQcOSw=/1500x0/filters:no_upscale():max_bytes(150000):strip_icc()/Mistakes-To-Avoid-When-Grilling-Steak-FT-BLOG0622-2000-9470d6138120449885c7b91524c51cc4.jpg",
        "Mediterranean",
        "Lamb",
        listOf("Lamb chops", "Rosemary", "Garlic"),
        listOf("1 kg", "2 sprigs", "4 cloves")
    )

    val recette14 = Recette(
        "14",
        "Vegan Lentil Soup",
        "A hearty and flavorful lentil soup made with vegetables and spices.",
        "https://www.funfoodfrolic.com/wp-content/uploads/2021/01/Stir-Fry-Pasta-Thumbnail.jpg",
        "International",
        "Vegan",
        listOf("Lentils", "Carrots", "Celery"),
        listOf("1 cup", "2", "2")
    )

    val recette15 = Recette(
        "15",
        "Vegan Tofu Stir-Fry",
        "A delicious and healthy stir-fry made with tofu, vegetables, and a savory sauce.",
        "https://www.funfoodfrolic.com/wp-content/uploads/2021/01/Stir-Fry-Pasta-Thumbnail.jpg",
        "Asian",
        "Vegan",
        listOf("Tofu", "Bell peppers", "Snow peas"),
        listOf("1 block", "2", "1 cup")
    )

    val recette16 = Recette(
        "16",
        "Vegan Chickpea Curry",
        "A flavorful and spicy chickpea curry that's perfect for a cozy dinner.",
        "https://www.funfoodfrolic.com/wp-content/uploads/2021/01/Stir-Fry-Pasta-Thumbnail.jpg",
        "Indian",
        "Vegan",
        listOf("Chickpeas", "Coconut milk", "Curry powder"),
        listOf("2 cans", "1 can", "2 tbsp")
    )

    fun chargeRecommended(): MutableList<Recette>{
        recommended.add(recette1)
        return recommended
    }
    fun chargeCategories() : MutableList<Category> {
        categories.add(category1)
        categories.add(category2)
        categories.add(category3)
        categories.add(category4)
        return categories
    }
    fun getMealsByCategory(category: String): MutableList<Recette> {
        val mealsByCategory = mutableListOf<Recette>()
        when (category) {
            "SeaFish" -> {
                mealsByCategory.add(recette1)
                mealsByCategory.add(recette5)
                mealsByCategory.add(recette6)
                mealsByCategory.add(recette7)
            }
            "Dessert" -> {
                mealsByCategory.add(recette2)
                mealsByCategory.add(recette8)
                mealsByCategory.add(recette9)
                mealsByCategory.add(recette10)
            }
            "Beef" -> {
                mealsByCategory.add(recette3)
                mealsByCategory.add(recette11)
                mealsByCategory.add(recette12)
                mealsByCategory.add(recette13)
            }
            "Vegan" -> {
                mealsByCategory.add(recette4)
                mealsByCategory.add(recette14)
                mealsByCategory.add(recette15)
                mealsByCategory.add(recette16)
            }
        }
        return mealsByCategory
    }


}