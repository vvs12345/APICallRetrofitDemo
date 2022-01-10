package com.example.apicallretrofitdemo.utils

import androidx.lifecycle.ViewModel
import dagger.MapKey
import kotlin.reflect.KClass

/**
 * <h1>ViewModelKey</h1>
 *
 * @author Mayur Dhanrajani (mayurd@meditab.com) Meditab Software Inc.
 * @since 9/4/20 11:01 AM
 *
 */

@MustBeDocumented
@Target(AnnotationTarget.FUNCTION)
@Retention(AnnotationRetention.RUNTIME)
@MapKey
annotation class ViewModelKey(val value: KClass<out ViewModel>)