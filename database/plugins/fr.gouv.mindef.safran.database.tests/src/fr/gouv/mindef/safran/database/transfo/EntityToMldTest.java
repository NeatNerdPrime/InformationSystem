package fr.gouv.mindef.safran.database.transfo;


import org.junit.Test;

public class EntityToMldTest extends AbstractTransformationTest {

	@Override
	String getModelsFolder() {
		return "/fr.gouv.mindef.safran.database.tests/models/entity2mld/";
	}

	@Test
	public void mediumEnDirect() {
		testEntityToMld("2-medium");
	}
	
	@Test
	public void mediumAvecScaffoldModel() {
		testEntityToMldWithScaffoldModel("2-medium");
	}
	
	@Test
	public void simpleAvecPkEtFk() {
		testEntityToMld("1-simple-pk-et-fk");
	}
	
	@Test
	public void referenceSupprimee() {
		testEntityToMldWithScaffoldModel("3-reference-supprimee");
	}
	
	@Test
	public void safran130Inverse() {
		testEntityToMld("4-safran-130-inverse");
	}
	
	@Test
	public void safran153ColumnLostInIndex() {
		testEntityToMldWithScaffoldModel("5-column-lost-in-index");
	}
	
	@Test
	public void safran156() {
		testEntityToMld("6-safran-156");
	}
	
	@Test
	public void multipleConstraintOnAnEntity() {
		testEntityToMld("7-multiple-constraints-on-entity");
	}
	
	@Test
	public void indexOnFk() {
		testEntityToMld("8-index-on-fk");
	}
	
	@Test
	public void handlingMultipleSchemas() {
		testEntityToMld("9-handling-schemas");
	}
	
	@Test
	public void handlingMultipleSchemasWithScaffold() {
		testEntityToMldWithScaffoldModel("10-handling-schemas-with-scaffold");
	}
	
	@Test
	public void renameTableWithScaffold() {
		testEntityToMldWithScaffoldModel("11-rename-table");
	}
	
	@Test
	public void multipleFKs() {
		testEntityToMld("12-multiple-fk");
	}
	
	@Test
	public void mindefCas1() {
		testEntityToMld("13-mindef-cas1");
	}
	
	@Test
	public void mindefCas2() {
		testEntityToMld("14-mindef-cas2");
	}
	
	@Test
	public void mindefCas3() {
		testEntityToMld("15-mindef-cas3");
	}
	
	@Test
	public void mindefCas4() {
		testEntityToMld("16-mindef-cas4");
	}
	
	@Test
	public void mindefCas5() {
		testEntityToMld("17-mindef-cas5");
	}
	
	@Test
	public void mindefSafran189() {
		testEntityToMld("18-safran-189");
	}
	
	@Test
	public void mindefSafran336() {
		testEntityToMld("19-safran-336-attribut-sans-type");
	}
	
	@Test
	public void mindefSafran428() {
		testEntityToMld("20-safran-428-associatedTypes");
	}
	
	@Test
	public void mindefSafran429() {
		testEntityToMld("21-safran-429-namespace-description");
	}
}
