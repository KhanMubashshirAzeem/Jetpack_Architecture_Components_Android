package com.example.jetpackcomponent_android.dataBinding

import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import com.example.jetpackcomponent_android.BR

/* BaseObservable is a class in Android's Data Binding Library that implements the Observable interface and makes it easier to register listeners for property changes:
What it does: BaseObservable allows you to configure model objects to notify other model variables when a variable changes.
How it works: The data class that implements BaseObservable is responsible for notifying when properties change. To do this, you can:
Assign a Bindable annotation to the getter
Call the notifyPropertyChanged() method in the setter */

class Vehicle : BaseObservable() {
    var modelYear: String = ""

    /* In Android, the @Bindable annotation is used to generate a field in the BR
   class  to react when the value of a field in an Observable class changes.
    It's applied to the getter of an Observable class.*/

    @Bindable
    var name: String = ""
        set(value) {
            field = value
            notifyPropertyChanged(BR.name)
        }
}

