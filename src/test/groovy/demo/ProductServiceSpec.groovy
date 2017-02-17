package demo

import grails.test.hibernate.HibernateSpec
import grails.test.mixin.Mock
import grails.test.mixin.TestFor

/**
 * See the API for {@link grails.test.mixin.services.ServiceUnitTestMixin} for usage instructions
 */
@TestFor(ProductService)
@Mock([Product])
class ProductServiceSpec extends HibernateSpec {

    void "test GORM save"() {
        when:
        def names = ['Groovy Calamari Sticker', 'Groovy Calamari T-Shirt']
        names.each {
            new Product(name: it).save()
        }

        then:
        Product.count() == names.size()
    }


    void "test criteria Query"() {

        when:
        def names = ['Groovy Calamari Sticker', 'Groovy Calamari T-Shirt']
        names.each {
            new Product(name: it).save()
        }

        then:
        Product.count() == names.size()

        when:
        def resultNames = service.findAllProductNames()

        then:
        resultNames
        resultNames.size() == names.size()

    }
}
