package com.app.server.service;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import com.app.config.WebConfigExtended;
import org.springframework.test.context.ContextConfiguration;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.TestExecutionListeners;
import com.app.server.repository.AddressRepository;
import com.app.shared.location.Address;
import org.springframework.beans.factory.annotation.Autowired;
import com.athena.framework.server.helper.RuntimeLogInfoHelper;
import com.athena.framework.server.helper.EntityValidatorHelper;
import com.athena.framework.server.test.RandomValueGenerator;
import java.util.HashMap;
import com.spartan.healthmeter.entity.scheduler.ArtMethodCallStack;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.junit.Before;
import org.junit.After;
import com.athena.framework.shared.entity.web.entityInterface.CommonEntityInterface.RECORD_TYPE;
import org.junit.Test;
import com.app.shared.location.AddressType;
import com.app.server.repository.AddressTypeRepository;
import com.app.shared.location.City;
import com.app.server.repository.CityRepository;
import com.app.shared.location.Country;
import com.app.server.repository.CountryRepository;
import com.app.shared.location.State;
import com.app.server.repository.StateRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = WebConfigExtended.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@TestExecutionListeners({ org.springframework.test.context.support.DependencyInjectionTestExecutionListener.class, org.springframework.test.context.support.DirtiesContextTestExecutionListener.class, org.springframework.test.context.transaction.TransactionalTestExecutionListener.class })
public class AddressTestCase {

    @Autowired
    private AddressRepository<Address> addressRepository;

    @Autowired
    private RuntimeLogInfoHelper runtimeLogInfoHelper;

    @Autowired
    private EntityValidatorHelper<Object> entityValidator;

    private RandomValueGenerator valueGenerator = new RandomValueGenerator();

    private static HashMap<String, Object> map = new HashMap<String, Object>();

    @Autowired
    private ArtMethodCallStack methodCallStack;

    protected MockHttpSession session;

    protected MockHttpServletRequest request;

    protected MockHttpServletResponse response;

    protected void startSession() {
        session = new MockHttpSession();
    }

    protected void endSession() {
        session.clearAttributes();
        session.invalidate();
        session = null;
    }

    protected void startRequest() {
        request = new MockHttpServletRequest();
        request.setSession(session);
        org.springframework.web.context.request.RequestContextHolder.setRequestAttributes(new org.springframework.web.context.request.ServletRequestAttributes(request));
    }

    protected void endRequest() {
        ((org.springframework.web.context.request.ServletRequestAttributes) org.springframework.web.context.request.RequestContextHolder.getRequestAttributes()).requestCompleted();
        org.springframework.web.context.request.RequestContextHolder.resetRequestAttributes();
        request = null;
    }

    @Before
    public void before() {
        startSession();
        startRequest();
        setBeans();
    }

    @After
    public void after() {
        endSession();
        endRequest();
    }

    private void setBeans() {
        runtimeLogInfoHelper.createRuntimeLogUserInfo(1, "AAAAA", request.getRemoteHost());
        org.junit.Assert.assertNotNull(runtimeLogInfoHelper);
        methodCallStack.setRequestId(java.util.UUID.randomUUID().toString().toUpperCase());
    }

    @Test
    public void test1Save() {
        try {
            AddressType addresstype = new AddressType();
            addresstype.setAddressType("WdziwZE2B89EBKPaip8YF6axl8gr3XlHXvjOyR8oJw1sYTOzvx");
            addresstype.setAddressTypeDesc("a2soeQz6DWrTj9ZEvfE8grbIB7pqN7U8ULw2Za8gYvQ3LeaIXl");
            addresstype.setAddressTypeIcon("00srieXJdkZOhl14x0d61q3UCMlP8MDDFKUYaqCqhdsZ8UMIm9");
            AddressType AddressTypeTest = addresstypeRepository.save(addresstype);
            map.put("AddressTypePrimaryKey", addresstype._getPrimarykey());
            City city = new City();
            city.setCityCode(3);
            city.setCityCodeChar2("qlyZILkviI7vAyQFsprZyHsAAnlNNz61");
            city.setCityDescription("UjnOn77XgNNpSp7Si0y6tO0vnsXoEmu9zS1J5DGb9KzcFqtmi9");
            city.setCityFlag("7VYIwVD21ds6KB47qVUb4VNp2BWLtNZt85sor9meq2XvRp5UeZ");
            city.setCityLatitude(6);
            city.setCityLongitude(9);
            city.setCityName("HCV7PwARfaZ4fFjTJ0BoLu6o5bgyW4qffh7knnhgTnAHml0nEO");
            Country country = new Country();
            country.setCapital("YTVdRX0OPpl3GWxarSvLdWxqbMQGdDyT");
            country.setCapitalLatitude(9);
            country.setCapitalLongitude(1);
            country.setCountryCode1("PU8");
            country.setCountryCode2("SUl");
            country.setCountryFlag("7XnqyeZCT0Vw9FL52e2QXoW4iAYcU8UtTHWQEhpGpf3uv71UR3");
            country.setCountryName("e96tu7qNLPBuxXgo7hCqsBNlxrR6hqJQP3yqjPoqDdAFoJXYiZ");
            country.setCurrencyCode("nO1");
            country.setCurrencyName("nFOQAmKh8Q9WWpi8y4ZS14qmRqvMc0v4uZ45kZ0tmeHYBUGfNr");
            country.setCurrencySymbol("cBF1QEUu1Ombqp7OJGjpITWIOdfyNyoh");
            country.setIsoNumeric(6);
            Country CountryTest = countryRepository.save(country);
            map.put("CountryPrimaryKey", country._getPrimarykey());
            State state = new State();
            state.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            state.setStateCapital("pX8yAjTnsJguZM9kDMx6PotUco4dHqrcC9nRNRyN4szrHjCFA6");
            state.setStateCapitalLatitude(11);
            state.setStateCapitalLongitude(10);
            state.setStateCode(0);
            state.setStateCodeChar2("PflgDyhCtgagd2vU8ZQvl8qXB3oH64Cl");
            state.setStateCodeChar3("Q75UmGEaK4h8r2akU26hJm83aaO0LDsG");
            state.setStateDescription("6uq7zT5ZUnFRFhWaNw7ZrSjdqiMgoKdAPTNWTXnQgA3ffeNNIX");
            state.setStateFlag("6SP74C7SfdisdfA9R7yAL7i6jrifIC0ApiF5zvTfm9zV9Y8fXp");
            state.setStateName("azfNAnCzAVrWZknoH0LDboqDdBNqjTcsYauvvmWogjhXvk4b44");
            State StateTest = stateRepository.save(state);
            map.put("StatePrimaryKey", state._getPrimarykey());
            city.setCityCode(3);
            city.setCityCodeChar2("7MeIj5KV14tJKkv6121FZj2ULhqrMOQ5");
            city.setCityDescription("sltkZk9el3eHW0XVC15dSVHge5fPIsSGAAMwUzm858dzqVSrno");
            city.setCityFlag("hiI89Z4ZgWxdX6kuFANywhMiVCnlHhHjaTcpI2IuhVkVYr1SbE");
            city.setCityLatitude(0);
            city.setCityLongitude(2);
            city.setCityName("zIao4FaOJjdtWTIT9KtcKYSGu6Z9hNK8dR38RVib6ZTgKdJkhW");
            city.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            city.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
            City CityTest = cityRepository.save(city);
            map.put("CityPrimaryKey", city._getPrimarykey());
            Address address = new Address();
            address.setAddress1("6jbK7rZdPPhdzJRZrOLuERNEWkqjf979jwKxq15LYpIcF6WXw9");
            address.setAddress2("FJiwe8oELT4ogFBWqKZoiyvWVlwmRVubGudvFwRcIGRsQVCXAf");
            address.setAddress3("X2zdtOWtfIffFS1RZqrOQmTf1kb7UdUMPV1jEzmuHcBOMGmElt");
            address.setAddressLabel("8QJm6y3nVMI");
            address.setAddressTypeId((java.lang.String) AddressTypeTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setCityId((java.lang.String) CityTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setLatitude("Xwd2PT5Lqo4dTVWozWOOtRS1uCJeNAlNtteHf1IjIHOiZ35VAF");
            address.setLongitude("89sEA7Jq4etyGgvbnIxbcR6ZxwcIBHzk9GlnhQTeW3dXpPZZWC");
            address.setStateId((java.lang.String) StateTest._getPrimarykey());
            address.setZipcode("sdbSwn");
            address.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            address.setEntityValidator(entityValidator);
            address.isValid();
            addressRepository.save(address);
            map.put("AddressPrimaryKey", address._getPrimarykey());
        } catch (com.athena.framework.server.exception.biz.SpartanConstraintViolationException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
    }

    @Autowired
    private AddressTypeRepository<AddressType> addresstypeRepository;

    @Autowired
    private CityRepository<City> cityRepository;

    @Autowired
    private CountryRepository<Country> countryRepository;

    @Autowired
    private StateRepository<State> stateRepository;

    @Test
    public void test2Update() {
        try {
            org.junit.Assert.assertNotNull(map.get("AddressPrimaryKey"));
            Address address = addressRepository.findById((java.lang.String) map.get("AddressPrimaryKey"));
            address.setAddress1("DXVpU4oidS6fUN8fu77mgt1WSVnedSWQhF4xloP0JFWCHFwNlC");
            address.setAddress2("Jbskp8ijeYTHAXuA2iDKVF6IihefRP9QnAc0ZGmlOHWROFsq5y");
            address.setAddress3("ktXKoQRG6yHIApVRQqYxIflF6NeoC5i6O3npdo6ZfvcRl3Yal3");
            address.setAddressLabel("JOP7iGFlyv7");
            address.setLatitude("ldZKUAd7KzSGGqJRMRGvg6SAFjEqTWcX8jxOeRhSdGQPlboIwb");
            address.setLongitude("Byo8GPSNHGqQLwoS1xjiWiAkqq5xrHLNN1klWuNXcuMGu7d5PT");
            address.setVersionId(1);
            address.setZipcode("QezMj1");
            address.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            addressRepository.update(address);
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test3FindById() {
        try {
            org.junit.Assert.assertNotNull(map.get("AddressPrimaryKey"));
            addressRepository.findById((java.lang.String) map.get("AddressPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test3findByaddressTypeId() {
        try {
            java.util.List<Address> listofaddressTypeId = addressRepository.findByAddressTypeId((java.lang.String) map.get("AddressTypePrimaryKey"));
            if (listofaddressTypeId.size() == 0) {
                org.junit.Assert.fail("Query did not return any records.");
            }
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test3findBycityId() {
        try {
            java.util.List<Address> listofcityId = addressRepository.findByCityId((java.lang.String) map.get("CityPrimaryKey"));
            if (listofcityId.size() == 0) {
                org.junit.Assert.fail("Query did not return any records.");
            }
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test3findBycountryId() {
        try {
            java.util.List<Address> listofcountryId = addressRepository.findByCountryId((java.lang.String) map.get("CountryPrimaryKey"));
            if (listofcountryId.size() == 0) {
                org.junit.Assert.fail("Query did not return any records.");
            }
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test3findBystateId() {
        try {
            java.util.List<Address> listofstateId = addressRepository.findByStateId((java.lang.String) map.get("StatePrimaryKey"));
            if (listofstateId.size() == 0) {
                org.junit.Assert.fail("Query did not return any records.");
            }
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test4Delete() {
        try {
            org.junit.Assert.assertNotNull(map.get("AddressPrimaryKey"));
            addressRepository.delete((java.lang.String) map.get("AddressPrimaryKey")); /* Deleting refrenced data */
            cityRepository.delete((java.lang.String) map.get("CityPrimaryKey")); /* Deleting refrenced data */
            stateRepository.delete((java.lang.String) map.get("StatePrimaryKey")); /* Deleting refrenced data */
            countryRepository.delete((java.lang.String) map.get("CountryPrimaryKey")); /* Deleting refrenced data */
            addresstypeRepository.delete((java.lang.String) map.get("AddressTypePrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
