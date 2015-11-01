package com.app.server.service;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import com.app.config.WebConfigExtended;
import org.springframework.test.context.ContextConfiguration;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.TestExecutionListeners;
import com.app.server.repository.CoreContactsRepository;
import com.app.shared.contacts.CoreContacts;
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
import com.app.shared.contacts.Gender;
import com.app.server.repository.GenderRepository;
import com.app.shared.location.Language;
import com.app.server.repository.LanguageRepository;
import com.app.shared.location.Timezone;
import com.app.server.repository.TimezoneRepository;
import com.app.shared.contacts.Title;
import com.app.server.repository.TitleRepository;
import com.app.shared.location.Address;
import com.app.server.repository.AddressRepository;
import com.app.shared.location.AddressType;
import com.app.server.repository.AddressTypeRepository;
import com.app.shared.location.City;
import com.app.server.repository.CityRepository;
import com.app.shared.location.Country;
import com.app.server.repository.CountryRepository;
import com.app.shared.location.State;
import com.app.server.repository.StateRepository;
import com.app.shared.contacts.CommunicationData;
import com.app.shared.contacts.CommunicationGroup;
import com.app.server.repository.CommunicationGroupRepository;
import com.app.shared.contacts.CommunicationType;
import com.app.server.repository.CommunicationTypeRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = WebConfigExtended.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@TestExecutionListeners({ org.springframework.test.context.support.DependencyInjectionTestExecutionListener.class, org.springframework.test.context.support.DirtiesContextTestExecutionListener.class, org.springframework.test.context.transaction.TransactionalTestExecutionListener.class })
public class CoreContactsTestCase {

    @Autowired
    private CoreContactsRepository<CoreContacts> corecontactsRepository;

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
            Gender gender = new Gender();
            gender.setGender("a1LdZY5IaLw6uvBqPrezo66PDT3HbQlsvviQe37hjEXyRwURD0");
            Gender GenderTest = genderRepository.save(gender);
            map.put("GenderPrimaryKey", gender._getPrimarykey());
            Language language = new Language();
            language.setAlpha2("BF");
            language.setAlpha3("jgU");
            language.setAlpha4("E8dH");
            language.setAlpha4parentid(5);
            language.setLanguage("fic0UggROtTlWzn1wuhuDAfrqSZA9NPI77KeHRn1wvw6COqRMA");
            language.setLanguageDescription("EiHd59WZjuPFtk9OpAWKwqnKkqv5sZqORM1AgsLf0yczoDCeP7");
            language.setLanguageIcon("24ikFvHUYBRWGTo01mI8tfDXiJAEOBza5pnh2B4h7pZ3m6g5WW");
            language.setLanguageType("yc5rh9v9jO2L0Bh2GctpBvU27WZekpee");
            Language LanguageTest = languageRepository.save(language);
            map.put("LanguagePrimaryKey", language._getPrimarykey());
            Timezone timezone = new Timezone();
            timezone.setCities("6srD38ZF2R0jJMoKVlK1v5qNCSx1i5NiHEZZ4hgk6pWaBPqsIQ");
            timezone.setCountry("oEqMKK4PF44AMxuTwpo2AMTWzUuiWChqQtkTHBjIVTxMxIIU4C");
            timezone.setGmtLabel("LP7Mrtdf8rkcE0RFvuPxdaeEM1U40W6zrhjNZyymvBa3jauVK2");
            timezone.setTimeZoneLabel("BA1seel3RieDUsxMsCGABrbSKzTsjNNnjFMwcnmxRXkk6MFQcb");
            timezone.setUtcdifference(7);
            Timezone TimezoneTest = timezoneRepository.save(timezone);
            map.put("TimezonePrimaryKey", timezone._getPrimarykey());
            Title title = new Title();
            title.setTitles("GCZkNCadZGL2MYfB20Glcc9QdoWfjkNZbOV3tfDcWFnqELB0Uz");
            Title TitleTest = titleRepository.save(title);
            map.put("TitlePrimaryKey", title._getPrimarykey());
            CoreContacts corecontacts = new CoreContacts();
            corecontacts.setAge(123);
            corecontacts.setApproximateDOB(new java.sql.Date(123456789));
            corecontacts.setDateofbirth(new java.sql.Date(123456789));
            corecontacts.setEmailId("oN0EjuSSS79qR30GOfjs9wX0fSor7FIwRWU1lxBUicHxrwPBLT");
            corecontacts.setFirstName("Rgd8ezyQ12ZXnsz6mbFYJkaop5H2PGOppzaHn2OuWE9ilX4Xfe");
            corecontacts.setGenderId((java.lang.String) GenderTest._getPrimarykey()); /* ******Adding refrenced table data */
            corecontacts.setLastName("ufISGg2rkxUFYUqVGSbLu6B8yjnzxxLQEJLtUF2cWHpqiyAjcO");
            corecontacts.setMiddleName("DM02lk5WhVi42lEenW5WARVhaY5JMT7r8UXNxSzoKx9OAczhk1");
            corecontacts.setNativeFirstName("qXRZN8aG3Zz41u3wlJgYLDSSu96psPFa5ThcJaXoKvexvVoDt0");
            corecontacts.setNativeLanguageCode((java.lang.String) LanguageTest._getPrimarykey()); /* ******Adding refrenced table data */
            corecontacts.setNativeLastName("n9Y3pCaFaW5fZfwHxBTjtXKgJWKtfSoIxyIEQ2zAVlWFpoZY86");
            corecontacts.setNativeMiddleName("I7LKP2kQbzQIkFH95yHrMsxq4ZFgWKPM3cgSh9qj1Zk1UcIbcZ");
            corecontacts.setNativeTitle("yEQhrHXhTBfBukhRsAIzWyoiQt9T2S0lPVS2btXZ82S1kYC32f");
            corecontacts.setPhoneNumber("wJG05DjWa00uXNgomPAx");
            corecontacts.setTimeZone((java.lang.String) TimezoneTest._getPrimarykey()); /* ******Adding refrenced table data */
            corecontacts.setTitleId((java.lang.String) TitleTest._getPrimarykey()); /* ******Adding refrenced table data */
            java.util.List<Address> listOfAddress = new java.util.ArrayList<Address>();
            Address address = new Address();
            address.setAddress1("zfkWhjA1s1eGtNmXOXzjwhYG8RQohBtPPNEeetxgNC5e01sKQy");
            address.setAddress2("sWJ9ToYkSB0pz6duOlhZ9wNX0n0zrzufJax3cNYJOowDeB0k42");
            address.setAddress3("2MUAcI1b1q2T096KE5MgsQB8UaZXRZFbCvPpTBdupCOHTlvjNi");
            address.setAddressLabel("UunpvqcYV0D");
            AddressType addresstype = new AddressType();
            addresstype.setAddressType("tKo2T0HTznATBQqWlEan2kXhu9w5Rl2Wcwf2zo5rSYKTqThXGh");
            addresstype.setAddressTypeDesc("tWWgRJId47mSwBIh3EAQkWuhoxObA1lDDsA6kfOzbfeqI6edY7");
            addresstype.setAddressTypeIcon("GjJyb4KIhMcYIPGZEujsxzNwqxu3BcqiZVZ2ZXU22em2CjyGVK");
            AddressType AddressTypeTest = addresstypeRepository.save(addresstype);
            map.put("AddressTypePrimaryKey", addresstype._getPrimarykey());
            City city = new City();
            city.setCityCode(0);
            city.setCityCodeChar2("C5KUaTn41KIMmJuqb0flA0OYz79Fd13J");
            city.setCityDescription("M0V6k8TKZDO3oz0xIIvUU3rK0qhUkyJVbvkDfaSjfirW1FAIH9");
            city.setCityFlag("fggiW8u1rVhCMgLPcRTDbM5kBdxiYvvG8KO93xgfvTPDa9XUBS");
            city.setCityLatitude(4);
            city.setCityLongitude(4);
            city.setCityName("ULngvFxdwt4AbzvSIBqQbRQGmGc7ZjeHJCY70jpc5vlt5ncWme");
            Country country = new Country();
            country.setCapital("Yrypn4HO2qYYFN4H69vWaujNwLuORH2f");
            country.setCapitalLatitude(3);
            country.setCapitalLongitude(2);
            country.setCountryCode1("QzD");
            country.setCountryCode2("bio");
            country.setCountryFlag("Fsiq3GkqADu9aPcmTBTnnRDN0SeuyqBRLtVwDZHSfqGWwvAaby");
            country.setCountryName("EykC0jQlm3NWxntP3EhhiIvOajHDV1FaVdepBQuIYNmArvjwoN");
            country.setCurrencyCode("86S");
            country.setCurrencyName("4wRcWe7LLVgea7VI9590VkROdyYIJzs8c9hgwVQbuKWJLeNctS");
            country.setCurrencySymbol("cjL6NPJmcDtW5C3TOJuBfZglWKZItdAp");
            country.setIsoNumeric(9);
            Country CountryTest = countryRepository.save(country);
            map.put("CountryPrimaryKey", country._getPrimarykey());
            State state = new State();
            state.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            state.setStateCapital("mOO4T1L79HEHh09IYIyvWV8I1vgrAaF2EHNFscMuoqgA0NS4pD");
            state.setStateCapitalLatitude(1);
            state.setStateCapitalLongitude(8);
            state.setStateCode(0);
            state.setStateCodeChar2("VndOwn7WzRr4uVfphmzGX4f9W9QCqiW3");
            state.setStateCodeChar3("vYSnzfe1FDomtlha5d9EgfIZ7wlWLm0a");
            state.setStateDescription("YwtJUUiZesIGQva6FiES9BtM6kBvj7umWDWL0kJqDQIs2Juue6");
            state.setStateFlag("mfetlHyR88WaLp7xTO0CqzbD2IVlMsBKG7lSb2QiG3HAnMM8Wl");
            state.setStateName("yNMkReb0GEfL3mvDnHMGSGL9m2ULtiRl9bwMq2wvg4AjVxofoN");
            State StateTest = stateRepository.save(state);
            map.put("StatePrimaryKey", state._getPrimarykey());
            city.setCityCode(2);
            city.setCityCodeChar2("zSV6fT9RONbRPhZhUovxVysXWi6EPf2i");
            city.setCityDescription("g2nzwhUrovCBGSKSwgTAciQnjvE59FVfhmFGTwQ1LYl6AgZR5b");
            city.setCityFlag("jojyQC2Ks40c3QxfySKRWbApzcGXchLimU4WWb8zOeZoDvFSUl");
            city.setCityLatitude(0);
            city.setCityLongitude(4);
            city.setCityName("QpmkQs72GVm1VCtMXGeDSaTS2ZwhEPMVCJoBtMFYy3fJmqI8Mn");
            city.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            city.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
            City CityTest = cityRepository.save(city);
            map.put("CityPrimaryKey", city._getPrimarykey());
            address.setAddress1("DGMdu3NaoDih2fX0I96sPQ3g4akC2sJbnHHvAQ0SXR8pfzQmS6");
            address.setAddress2("OGW6EOHHq0Aqqg5cNbmVxZrPqadzVHiKhL0mKYqXeT8qc9Cy5X");
            address.setAddress3("JW7Q6KkUx42UaOxnvXVqUKInA9sHSvC6y53nCsN4CmyOKVo0oV");
            address.setAddressLabel("kMzyhn6UGpT");
            address.setAddressTypeId((java.lang.String) AddressTypeTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setCityId((java.lang.String) CityTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setLatitude("ebzT4uFJ2tFy8B1Conh8vg0Tryyn4EC1B4KwxzRNPyDpzWG7Oj");
            address.setLongitude("3eriJk8KlLlRRfDd6QqFs6x0olUHK08cCyhcXofFKuupRtLGAd");
            address.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setZipcode("sXxi6H");
            listOfAddress.add(address);
            corecontacts.addAllAddress(listOfAddress);
            java.util.List<CommunicationData> listOfCommunicationData = new java.util.ArrayList<CommunicationData>();
            CommunicationData communicationdata = new CommunicationData();
            communicationdata.setCommData("HiW");
            CommunicationGroup communicationgroup = new CommunicationGroup();
            communicationgroup.setCommGroupDescription("bpv9CFDNG9Akkr9PLrqZ4Q1OlSSWDSUZuhPYVFx9uo4UbULL3o");
            communicationgroup.setCommGroupName("3ltViZUVeJLnYHcQSmaNPHWF4krlBPeXAervm4j5QlPQoN1Y9r");
            CommunicationGroup CommunicationGroupTest = communicationgroupRepository.save(communicationgroup);
            map.put("CommunicationGroupPrimaryKey", communicationgroup._getPrimarykey());
            CommunicationType communicationtype = new CommunicationType();
            communicationtype.setCommGroupId((java.lang.String) CommunicationGroupTest._getPrimarykey()); /* ******Adding refrenced table data */
            communicationtype.setCommTypeDescription("R6aR2KzgFVfDuSIC79OkLM3pGvERjdoNl120EAMjhJnqX5Yrs8");
            communicationtype.setCommTypeName("E0Bu6YB1FswdjBdegJsf22RoyEnShIuwM5WNLekJOCZrvOe0bg");
            CommunicationType CommunicationTypeTest = communicationtypeRepository.save(communicationtype);
            map.put("CommunicationTypePrimaryKey", communicationtype._getPrimarykey());
            communicationdata.setCommData("yaR");
            communicationdata.setCommGroupId((java.lang.String) CommunicationGroupTest._getPrimarykey()); /* ******Adding refrenced table data */
            communicationdata.setCommType((java.lang.String) CommunicationTypeTest._getPrimarykey());
            listOfCommunicationData.add(communicationdata);
            corecontacts.addAllCommunicationData(listOfCommunicationData);
            corecontacts.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            corecontacts.setEntityValidator(entityValidator);
            corecontacts.isValid();
            corecontactsRepository.save(corecontacts);
            map.put("CoreContactsPrimaryKey", corecontacts._getPrimarykey());
        } catch (com.athena.framework.server.exception.biz.SpartanConstraintViolationException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
    }

    @Autowired
    private GenderRepository<Gender> genderRepository;

    @Autowired
    private LanguageRepository<Language> languageRepository;

    @Autowired
    private TimezoneRepository<Timezone> timezoneRepository;

    @Autowired
    private TitleRepository<Title> titleRepository;

    @Autowired
    private AddressRepository<Address> addressRepository;

    @Autowired
    private AddressTypeRepository<AddressType> addresstypeRepository;

    @Autowired
    private CityRepository<City> cityRepository;

    @Autowired
    private CountryRepository<Country> countryRepository;

    @Autowired
    private StateRepository<State> stateRepository;

    @Autowired
    private CommunicationGroupRepository<CommunicationGroup> communicationgroupRepository;

    @Autowired
    private CommunicationTypeRepository<CommunicationType> communicationtypeRepository;

    @Test
    public void test2Update() {
        try {
            org.junit.Assert.assertNotNull(map.get("CoreContactsPrimaryKey"));
            CoreContacts corecontacts = corecontactsRepository.findById((java.lang.String) map.get("CoreContactsPrimaryKey"));
            corecontacts.setAge(106);
            corecontacts.setApproximateDOB(new java.sql.Date(123456789));
            corecontacts.setDateofbirth(new java.sql.Date(123456789));
            corecontacts.setEmailId("cPIRzns1HrfcuFa24MtZ763wQ4b0zPBh7NZ1N4H8ZajVvmE6mT");
            corecontacts.setFirstName("on0zRh9ethyGW2rxcvlsveZIEseRQWV7oSGjOWDm8GP4toaGF9");
            corecontacts.setLastName("118rKFF8fKuALTXGlbjqUGLAjEmL15rSNuA5W8RDgXFrtppcI0");
            corecontacts.setMiddleName("GWCzXpnFpLEWv6Vzi2mzIHohjT6LR2lvKPDp14GZ4kWJuxjvut");
            corecontacts.setNativeFirstName("KFFtaWMUxF71tRs2mrO4t4jspelHrjejoGD8B4rtsJwwvpX6cR");
            corecontacts.setNativeLastName("mpKzo3hpqiFGIqu8DAUglwFdnRJDuhPLspsOCiWAgQyWUQaL2Y");
            corecontacts.setNativeMiddleName("134UzHSxaOPQnvkHaRrFk1w2lvxw9GO3xkZGiPgjHMFRSJmiUv");
            corecontacts.setNativeTitle("Ri60BjmYxDYSyZ5sUi0nonxAYE8LasBc2mpF4PA2YstNh2hMYg");
            corecontacts.setPhoneNumber("vuVdEGAMHzWMKvyVtj9s");
            corecontacts.setVersionId(1);
            corecontacts.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            corecontactsRepository.update(corecontacts);
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test3FindById() {
        try {
            org.junit.Assert.assertNotNull(map.get("CoreContactsPrimaryKey"));
            corecontactsRepository.findById((java.lang.String) map.get("CoreContactsPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test3findBygenderId() {
        try {
            java.util.List<CoreContacts> listofgenderId = corecontactsRepository.findByGenderId((java.lang.String) map.get("GenderPrimaryKey"));
            if (listofgenderId.size() == 0) {
                org.junit.Assert.fail("Query did not return any records.");
            }
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test3findBynativeLanguageCode() {
        try {
            java.util.List<CoreContacts> listofnativeLanguageCode = corecontactsRepository.findByNativeLanguageCode((java.lang.String) map.get("LanguagePrimaryKey"));
            if (listofnativeLanguageCode.size() == 0) {
                org.junit.Assert.fail("Query did not return any records.");
            }
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test3findBytimeZone() {
        try {
            java.util.List<CoreContacts> listoftimeZone = corecontactsRepository.findByTimeZone((java.lang.String) map.get("TimezonePrimaryKey"));
            if (listoftimeZone.size() == 0) {
                org.junit.Assert.fail("Query did not return any records.");
            }
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test3findBytitleId() {
        try {
            java.util.List<CoreContacts> listoftitleId = corecontactsRepository.findByTitleId((java.lang.String) map.get("TitlePrimaryKey"));
            if (listoftitleId.size() == 0) {
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
            org.junit.Assert.assertNotNull(map.get("CoreContactsPrimaryKey"));
            corecontactsRepository.delete((java.lang.String) map.get("CoreContactsPrimaryKey")); /* Deleting refrenced data */
            communicationtypeRepository.delete((java.lang.String) map.get("CommunicationTypePrimaryKey")); /* Deleting refrenced data */
            communicationgroupRepository.delete((java.lang.String) map.get("CommunicationGroupPrimaryKey")); /* Deleting refrenced data */
            cityRepository.delete((java.lang.String) map.get("CityPrimaryKey")); /* Deleting refrenced data */
            stateRepository.delete((java.lang.String) map.get("StatePrimaryKey")); /* Deleting refrenced data */
            countryRepository.delete((java.lang.String) map.get("CountryPrimaryKey")); /* Deleting refrenced data */
            addresstypeRepository.delete((java.lang.String) map.get("AddressTypePrimaryKey")); /* Deleting refrenced data */
            titleRepository.delete((java.lang.String) map.get("TitlePrimaryKey")); /* Deleting refrenced data */
            timezoneRepository.delete((java.lang.String) map.get("TimezonePrimaryKey")); /* Deleting refrenced data */
            languageRepository.delete((java.lang.String) map.get("LanguagePrimaryKey")); /* Deleting refrenced data */
            genderRepository.delete((java.lang.String) map.get("GenderPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
