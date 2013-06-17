
CDI via JBoss Weld
------------------

Plugin page: [http://artifacts.griffon-framework.org/plugin/weld](http://artifacts.griffon-framework.org/plugin/weld)


Enables the usage of [Weld][1] as Dependency Injection provider, and much more!

Usage
-----

Weld will automatically autowire all dependencies marked with `@javax.inject.Inject`. The plugin also allows you to define
additional beans, interceptors and alternatives in the standard `beans.xml` file located in `griffon-app/conf/metainf`.

Every instance created using the framework's facilities (in other words, those those that trigger a 'NewInstance' event) will
also participate in the benefits of Weld managed injections. This means you annotate controller, models, and pretty much any
artifact supported by Griffon.

There are two properties added to the application instance

 * **weld** - of type `org.jboss.weld.environment.se.Weld`
 * **weldContainer** - of type `org.jboss.weld.environment.se.WeldContainer`

Addons can inject beans during startup. The Weld addon published an event named "BeforeWeld" that can be used to define a set
of beans to be added to the BeanManager. Here's how the [DataSource plugin][2] does it to inject the default datasource

        def events = [
            BeforeWeld: { Map beans ->
                beans.dataSource = DataSourceHolder.instance.getDataSource('default')
            }
        ]

### Example

A trivial sample application can be found at [https://github.com/aalmiray/griffon_sample_apps/tree/master/demos/numberguess][3]

[1]: http://seamframework.org/Weld
[2]: /plugin/datasource
[3]: https://github.com/aalmiray/griffon_sample_apps/tree/master/demos/numberguess

