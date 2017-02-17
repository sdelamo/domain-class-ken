package demo

import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Product)
class ProductSpec extends Specification {
    Product p = new Product(name: 'name')

    void 'default should be valid'() {
        expect:
        p.validate()
    }

    void 'name can not be blank'() {
        when:
        p.name = '  '

        then:
        !p.validate()
        p.errors.getFieldError('name').code == 'blank'
    }
}
