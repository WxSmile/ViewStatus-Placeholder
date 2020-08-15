# ViewStatus-Placeholder
### Introduction

This is a android library for **multi-view-status-placeholder**.

### Useage

1. Adding **Hilt** to you application.

2. Add it in your root **build.gradle** at the end of repositories.

   ```groovy
   repositories {
       jcenter()
   }
   ```

   

3. Add dependencies.

   ```groovy
   implementation 'com.murphy.view.status.placeholder:view-status-placeholder:1.0.0'
   ```

   

4. Define module provide template placeholder fragment in you application that mapping common **multi-view-status-placeholder**.

   ```kotlin
   import com.murphy.status.placeholder.PlaceholderFragment
   
   @Module
   @InstallIn(ActivityComponent::class)
   class PlaceholderModule {
   
       @Provides
       @ActivityScoped
       @Blank
       fun provideBlankPlaceholder(): PlaceholderFragment {
           return BlankFragment()
       }
   
       @Provides
       @ActivityScoped
       @Loading
       fun provideLoadingPlaceholder(): PlaceholderFragment {
           return LoadingFragment()
       }
   
       @Provides
       @ActivityScoped
       @Error
       fun provideErrorPlaceholder(): PlaceholderFragment {
           return ErrorFragment()
       }
   }
   ```

   

5. Use inject for **PlaceholderNavigation**.

   ```kotlin
   @AndroidEntryPoint
   class MainActivity : AppCompatActivity() {
   
       @Inject
       lateinit var placeholderNavigation: PlaceholderNavigation
   
       override fun onCreate(savedInstanceState: Bundle?) {
           super.onCreate(savedInstanceState)
           setContentView(R.layout.activity_main)
           //placeholderNavigation.navigationPlaceholder(this, LOADING)
           placeholderNavigation.navigationPlaceholder(this, LOADING, R.id.container)
       }
   }
   ```

   

6. And you can also define you placeholder fragment for special.

   ```kotlin
   import com.murphy.status.placeholder.PlaceholderFragment
   class NetErrorFragment constructor(): PlaceholderFragment() {
   
       override fun getPlaceholderLayout(): Int {
           return R.layout.common_fragment_net_error_placeholder
       }
   }
   ```

   then use it that you defined

   ```kotlin
   placeholderNavigation.navigationPlaceholder(this, NetErrorFragment())
   ```



### More

- see source code!



