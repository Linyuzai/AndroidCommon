package eason.linyuzai.easonbar.nav.component;

import eason.linyuzai.easonbar.nav.EasonNav;

/**
 * Created by linyuzai on 2018/5/11.
 *
 * @author linyuzai
 */

public interface EasonNavController {
    <T extends EasonNav.BaseEntity> T getEntity(int location);

    <T extends EasonNav.BaseEntity> void setEntity(T entity, int location);

    <T extends EasonNav.BaseEntity> void setEntityWithLayout(T entity, int location);

    void initialize(int location);

    void initialize();
}
