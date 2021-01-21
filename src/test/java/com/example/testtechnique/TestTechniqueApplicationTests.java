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
		Assert.assertEquals( "bavonjavour", classTested.translateFrenchToJava("bonjour") );
		Assert.assertEquals( "bonjour", classTested.translaterJavaToFrench("bavonjavour") );

		Assert.assertEquals( "avexavemplave", classTested.translateFrenchToJava("exemple") );
		Assert.assertEquals( "exemple", classTested.translaterJavaToFrench("avexavemplave") );


		// Cas complexes

		//Assert.assertEquals( "Chavantave", classTested.translateFrenchToJava("Chante") );
		//Assert.assertEquals( "MAVOYEN", classTested.translateFrenchToJava("MOYEN") );

		Assert.assertEquals( "avélavéphavant", classTested.translateFrenchToJava("éléphant") );
		Assert.assertEquals( "éléphant", classTested.translaterJavaToFrench("avélavéphavant") );

		Assert.assertEquals( "javavava", classTested.translateFrenchToJava("java") );
		Assert.assertEquals( "java", classTested.translaterJavaToFrench("javavava") );

		Assert.assertEquals( "lave gavâtaveau avest avun mavensavongave.", classTested.translateFrenchToJava("le gâteau est un mensonge.") );
		Assert.assertEquals( "le gâteau est un mensonge.", classTested.translaterJavaToFrench("lave gavâtaveau avest avun mavensavongave.") );

		// Cas exception
		Assert.assertEquals( "", classTested.translateFrenchToJava("") );
		Assert.assertEquals( "", classTested.translaterJavaToFrench("") );
		Assert.assertEquals( "12345", classTested.translateFrenchToJava("12345") );
	}
}
