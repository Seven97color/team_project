package model.entity;

import java.io.Serializable;
import java.util.Date;

public class TweetBean implements Serializable {
	/**
	 * tweetID
	 */
	private int id;

	/**
	 * tweet名前
	 */
	private String name;

	/**
	 * tweetメッセージ
	 */
	private String message;

	/**
	 * tweet更新日
	 */
	private Date updateDate;

	/**
	 * 引数なしデフォルトコンストラクタ
	 */
	public TweetBean() {
	}

	/**
	 * 引数ありコンストラクタ
	 * @param id tweetID
	 * @param name tweet名前
	 * @param message tweetメッセージ
	 * @param updateDate tweet更新日時
	 */
	public TweetBean(int id, String name, String message, Date updateDate) {
		this.id = id;
		this.name = name;
		this.message = message;
		this.updateDate = updateDate;
	}

	/**
	 * @return id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id セットする id
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name セットする name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @param message セットする message
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	/**
	 * @return updateDate
	 */
	public Date getUpdateDate() {
		return updateDate;
	}

	/**
	 * @param updateDate セットする updateDate
	 */
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
}
