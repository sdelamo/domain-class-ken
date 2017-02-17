package demo

import grails.transaction.Transactional
import groovy.transform.CompileStatic
import groovy.transform.TypeCheckingMode

@CompileStatic
@Transactional
class ProductService {

    @CompileStatic(TypeCheckingMode.SKIP)
    List<String> findAllProductNames() {
        def c = Product.createCriteria()
        c.list {
            projections {
                property('name')
            }
        }.collect { it[0] } as List<String>
    }
}

