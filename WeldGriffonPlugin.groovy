/*
 * Copyright 2011 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

/**
 * @author Andres Almiray
 */
class WeldGriffonPlugin {
    // the plugin version
    String version = '0.4'
    // the version or versions of Griffon the plugin is designed for
    String griffonVersion = '1.0.0 > *'
    // the other plugins this plugin depends on
    Map dependsOn = [:]
    // resources that are included in plugin packaging
    List pluginIncludes = []
    // the plugin license
    String license = 'Apache Software License 2.0'
    // Toolkit compatibility. No value means compatible with all
    // Valid values are: swing, javafx, swt, pivot, gtk
    List toolkits = []
    // Platform compatibility. No value means compatible with all
    // Valid values are:
    // linux, linux64, windows, windows64, macosx, macosx64, solaris
    List platforms = []
    // URL where documentation can be found
    String documentation = ''
    // URL where source can be found
    String source = 'https://github.com/griffon/griffon-weld-plugin'

    List authors = [
        [
            name: 'Andres Almiray',
            email: 'aalmiray@yahoo.com'
        ]
    ]
    String title = 'CDI via JBoss Weld'
    // accepts Markdown syntax. See http://daringfireball.net/projects/markdown/ for details
    String description = '''
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
'''
}
