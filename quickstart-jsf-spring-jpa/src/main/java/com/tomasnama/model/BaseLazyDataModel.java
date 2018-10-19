package com.tomasnama.model;

import java.util.List;
import java.util.Map;

import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortMeta;
import org.primefaces.model.SortOrder;
import org.springframework.data.domain.Sort;

public abstract class BaseLazyDataModel<T> extends LazyDataModel<T> {
	protected Map<String, Object> customfilter;

	@Override
	public List<T> load(int first, int pageSize, List<SortMeta> multiSortMeta, Map<String, Object> filters) {
		throw new UnsupportedOperationException("Lazy loading is not implemented.");
	}

	/**
	 * Convert SortOrder to Sort
	 * 
	 * @param sortField
	 * @param sortOrder
	 * @return Sort
	 */
	public Sort getSort(String sortField, SortOrder sortOrder) {
		Sort sort = null;
		if (sortField != null && !sortField.isEmpty()) {
			if (SortOrder.ASCENDING.equals(sortOrder)) {
				sort = new Sort(Sort.Direction.ASC, sortField);
			} else if (SortOrder.DESCENDING.equals(sortOrder)) {
				sort = new Sort(Sort.Direction.DESC, sortField);
			}
		}
		return sort;
	}

	public Map<String, Object> getCustomfilter() {
		return customfilter;
	}

	public void setCustomfilter(Map<String, Object> customfilter) {
		this.customfilter = customfilter;
	}

	@Override
	public void setRowIndex(int rowIndex) {
		if (rowIndex == -1 || getPageSize() == 0) {
			super.setRowIndex(-1);
		} else {
			super.setRowIndex(rowIndex % getPageSize());
		}
	}

}
