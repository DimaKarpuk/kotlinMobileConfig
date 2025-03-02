package tests

import com.codeborne.selenide.Condition.text
import com.codeborne.selenide.Selectors.byId
import com.codeborne.selenide.Selenide.*
import com.codeborne.selenide.logevents.SelenideLogger.step
import io.appium.java_client.AppiumBy.id
import org.junit.jupiter.api.Test

class Tests : TestBase() {
    @Test
    fun itemMenuTest(){
        step("Открываем меню корзина", {
            `$$`(byId("by.oz.android:id/bottom_navigation_item_icon"))[2].click()
        })
        step("Проверяем что находимася на экране корзина", {
            `$`(id("by.oz.android:id/toolbarRootTitleTv")).shouldHave(text("Корзина"))
        })
    }
}
