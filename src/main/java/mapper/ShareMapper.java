package mapper;

import entity.Share;

import java.util.List;

/**
 * @author yuyu
 * @since 2018/2/7 19:18
 */
public interface ShareMapper {
    /**
     * 新增分享
     * @param share
     */
    void addShare(Share share);

    /**
     * 删除分享
     * @param share
     */
    void delete(Share share);

    /**
     * 查询用户分享
     * @param share
     * @return
     */
    List<Share> getUserAll(Share share);

    /**
     * 查询用户所有分享
     * @param share
     * @return
     */
    List<Share> getAll(Share share);
}
