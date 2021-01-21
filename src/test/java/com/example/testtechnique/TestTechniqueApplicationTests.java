package com.example.testtechnique;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
class TestTechniqueApplicationTests {

	private TestTechniqueApplication classTested = new TestTechniqueApplication();

	@Test
	void contextLoads() {

		// Cas standards
		Assert.assertEquals( "bavonjavour", classTested.translater("bonjour") );
		Assert.assertEquals( "avexavemplave", classTested.translater("exemple") );
		Assert.assertEquals( "avau", classTested.translater("au") );

		// Cas complexes
		Assert.assertEquals( "chavantave", classTested.translater("Chante") );
		Assert.assertEquals( "mavoyen", classTested.translater("MOYEN") );
		Assert.assertEquals( "avélavéphavant", classTested.translater("éléphant") );
		Assert.assertEquals( "javavava", classTested.translater("java") );
		Assert.assertEquals( "lave gavâtaveau avest avun mavensavongave.", classTested.translater("Le gâteau est un mensonge.") );

		// Cas extremes
		Assert.assertEquals( "", classTested.translater("") );
	}
}
