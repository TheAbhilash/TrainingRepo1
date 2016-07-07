package org.cap.product.test;

import org.junit.experimental.categories.Categories;
import org.junit.experimental.categories.Categories.IncludeCategory;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Categories.class)
@SuiteClasses({ ProductTestApp.class, ProductTestApp2.class })
@IncludeCategory({GoodTestCategory.class})
public class AllTests {

}
