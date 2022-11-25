package com.example.sosalud.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

class Persons(
    @StringRes val stringResourceId: Int,
    @StringRes val stringResourceDate: Int,
    @StringRes val stringResourceAddres: Int,
    @DrawableRes val imageResourceId: Int
)