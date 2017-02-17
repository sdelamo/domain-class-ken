package demo

import grails.test.hibernate.HibernateSpec
import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.services.ServiceUnitTestMixin} for usage instructions
 */
@TestFor(ProductServiceHQLService)
class ProductServiceHQLServiceSpec extends HibernateSpec {

    void "test hql query, use HibernateSpec."() {

        when:
        def names = ['Groovy Calamari Sticker', 'Groovy Calamari T-Shirt']
        names.each {
            new Product(name: it).save()
        }

        then:
        Product.count() == names.size()

        when:
        def resultNames = service.findAllProductNamesWithHql()

        then:
        resultNames
        resultNames.size() == names.size()
    }
}
