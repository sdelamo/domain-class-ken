package demo

import grails.transaction.Transactional
import groovy.transform.CompileStatic

@CompileStatic
@Transactional
class ProductServiceHQLService {

    List<String> findAllProductNamesWithHql() {
        Product.executeQuery("select distinct p.name from Product p order by p.name")
    }
}
