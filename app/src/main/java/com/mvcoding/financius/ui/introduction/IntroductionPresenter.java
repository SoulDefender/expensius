/*
 * Copyright (C) 2015 Mantas Varnagiris.
 *
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 */

package com.mvcoding.financius.ui.introduction;

import android.support.annotation.NonNull;

import com.mvcoding.financius.ui.Presenter;
import com.mvcoding.financius.ui.PresenterView;

import rx.Observable;
import rx.android.view.OnClickEvent;

class IntroductionPresenter extends Presenter<IntroductionPresenter.View> {
    @Override protected void onViewAttached(@NonNull View view) {
        super.onViewAttached(view);
        unsubscribeOnDetach(view.onSkipLoginClick().subscribe(onClickEvent -> view.startOverviewAndClose()));
        unsubscribeOnDetach(view.onLoginClick().subscribe(onClickEvent -> view.startLoginAndClose()));
    }

    public interface View extends PresenterView {
        @NonNull Observable<OnClickEvent> onSkipLoginClick();

        @NonNull Observable<OnClickEvent> onLoginClick();

        void startOverviewAndClose();

        void startLoginAndClose();
    }
}
