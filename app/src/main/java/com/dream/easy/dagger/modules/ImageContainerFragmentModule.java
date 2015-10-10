package com.dream.easy.dagger.modules;

import com.dream.easy.model.IImagesContainerModel;
import com.dream.easy.model.impl.ImagesContainerModelImpl;
import com.dream.easy.presenter.IImagesContainerPresenter;
import com.dream.easy.presenter.impl.ImagesContainerPresenterImpl;
import com.dream.easy.ui.fragment.ImagesContainerFragment;
import com.dream.easy.view.IImagesContainerFragmentView;
import com.dream.library.dagger.FragmentScope;

import dagger.Module;
import dagger.Provides;

/**
 * Author:      SuSong
 * Email:       751971697@qq.com | susong0618@163.com
 * GitHub:      https://github.com/susong0618
 * Date:        15/10/8 下午11:26
 * Description: EasyFrame
 */
@Module
public class ImageContainerFragmentModule {

    private ImagesContainerFragment mImagesContainerFragment;

    public ImageContainerFragmentModule(ImagesContainerFragment imagesContainerFragment) {
        mImagesContainerFragment = imagesContainerFragment;
    }

    @Provides
    @FragmentScope
    ImagesContainerFragment provideImagesContainerFragment() {
        return mImagesContainerFragment;
    }

    @Provides
    @FragmentScope
    IImagesContainerFragmentView provideICommonContainerView(ImagesContainerFragment imagesContainerFragment) {
        return imagesContainerFragment;
    }

    @Provides
    @FragmentScope
    IImagesContainerModel provideImagesContainerModel() {
        return new ImagesContainerModelImpl();
    }

    @Provides
    @FragmentScope
    IImagesContainerPresenter provideImagesContainerPresenter(
        ImagesContainerFragment imagesContainerFragment,
        IImagesContainerFragmentView commonContainerView,
        IImagesContainerModel commonContainerModel) {
        return new ImagesContainerPresenterImpl(
            imagesContainerFragment,
            commonContainerView,
            commonContainerModel);
    }
}
